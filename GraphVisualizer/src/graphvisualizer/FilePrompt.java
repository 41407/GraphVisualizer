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
import UserInterface.GraphCanvas;
import UserInterface.GraphDrawer;
import UserInterface.UILogic;
import UserInterface.Window;
import Visualizer.AlgorithmInterface;
import Visualizer.AssignCoordinates;
import Visualizer.GraphInterface;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41407
 */
public class FilePrompt {

    private static Scanner s = new Scanner(System.in);

    static void filePrompt() {
        Graph g = null;
        while (g == null) {
            System.out.println("Which file to read graph from?");
            System.out.println("Or alternatively, type 'random size' for randomly"
                    + "generated graph, eg. 'random 4' for a graph with 4 vertices.");
            String graph = s.nextLine();

            try {
                g = GraphParser.initialize(FileLoader.loadFile(graph));
            } catch (FileNotFoundException ex) {
                System.out.println("File not found, try again.");

            }
            if (g != null) {
                AssignCoordinates.initialize(g);
                GraphInterface.setGraph(g);
                String algorithmChoice = "";
                if (g.isDirected()) {
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
                    }
                } else {
                    AlgorithmInterface.setAlgorithm(new BreadthFirstSearch(GraphInterface.getGraph()));
                }
                UILogic.start();
            }
        }
    }
}