/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphvisualizer;

import Algorithms.BreadthFirstSearch;
import Algorithms.Dijkstra;
import Graph.Graph;
import GraphDataHandler.FileLoader;
import GraphDataHandler.GraphParser;
import GraphDataHandler.RandomGraph;
import UserInterface.UILogic;
import Visualizer.AlgorithmInterface;
import Visualizer.AssignCoordinates;
import Visualizer.GraphInterface;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Command prompt that asks which graph to draw and which algorithm to use.
 *
 * @author 41407
 */
public class FilePrompt {

    private static Scanner s = new Scanner(System.in);

    /**
     * Asks user for a graph file to load, then loads said graph and initializes
     * it
     */
    static void filePrompt() {
        Graph g = null;
        while (g == null) {
            System.out.println("Which file to read graph from?");
            System.out.println("Or alternatively, type 'random size' for randomly "
                    + "generated graph, eg. 'random 4' for a graph with 4 vertices, "
                    + "or 'quick size' for a quicker graph generation algorithm with "
                    + "'size' vertices.");
            String graph = s.nextLine();
            if (!graph.startsWith("random") && !graph.startsWith("quick")) {
                try {
                    g = GraphParser.initialize(FileLoader.loadFile(graph));
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found, try again.");

                }
            } else if (graph.startsWith("random")) {
                g = GraphParser.initialize(RandomGraph.generateRandom(Integer.parseInt(graph.substring(7))));
            } else if (graph.startsWith("quick")) {
                g = RandomGraph.quick(Integer.parseInt(graph.substring(6)));
            }
            if (g != null) {
                AssignCoordinates.initialize(g);
                GraphInterface.setGraph(g);
                String algorithmChoice = "";
                algorithmPrompt(g);
            }
        }
    }

    /**
     * Asks user which algorithm to use with parameter graph.
     *
     * @param g Graph to evaluate
     */
    private static void algorithmPrompt(Graph g) {
        String algorithmChoice;
        if (!g.hasNegativeWeights()) {
            while (true) {
                System.out.println("Which algorithm to use?");
                System.out.println("  b - Breadth-first search");
                System.out.println("  d - Dijkstra's algorithm");
                algorithmChoice = s.nextLine();
                if (algorithmChoice.equals("b")) {
                    AlgorithmInterface.setAlgorithm(new BreadthFirstSearch(GraphInterface.getGraph()));
                    break;
                } else if (algorithmChoice.equals("d")) {
                    AlgorithmInterface.setAlgorithm(new Dijkstra(GraphInterface.getGraph()));
                    break;
                }
            }
        } else {
            System.out.println("Graph has negative edge weights so breadth-first search will be used.");
            AlgorithmInterface.setAlgorithm(new BreadthFirstSearch(GraphInterface.getGraph()));
        }

        UILogic.start();
    }
}