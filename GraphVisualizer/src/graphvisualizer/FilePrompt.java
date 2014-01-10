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
 *
 * @author 41407
 */
public class FilePrompt {

    private static Scanner s = new Scanner(System.in);

    static void filePrompt() {
        String file = "Don't judge me!";
        String cheesyPrompt = "Which file to read graph from? \n"
                + "Or alternatively type 'random size' for randomly generated\n"
                + "graph, eg. 'random 4'";
        Graph g;
        while (!file.equals("quit")) {
            try {
       //         String path = FilePrompt.class.getResource("src/" + file + ".txt").getPath(); 
              
                
                g = GraphParser.initialize(FileLoader.loadFile("src/" + file + ".txt"));
                AssignCoordinates.initialize(g);
                GraphInterface.setGraph(g);
                algorithmPrompt();
                UILogic.start();
                break;
            } catch (FileNotFoundException ex) {
                System.out.println(cheesyPrompt);
                file = s.nextLine();;
                cheesyPrompt = "File not found, try again. \nWhich file to read graph from?";
                if (file.startsWith("random ")) {
                    int size = Integer.parseInt(file.substring(7));
                    g = GraphParser.initialize(RandomGraph.generate(size));
                    AssignCoordinates.initialize(g);
                    GraphInterface.setGraph(g);
                    algorithmPrompt();
                    UILogic.start();
                    break;
                }
            }
        }
    }

    private static void algorithmPrompt() {
        String algorithm = "";
        if (GraphInterface.getGraph().isDirected()) {
            while (!algorithm.equals("d") && !algorithm.equals("b")) {
                System.out.println("Which algorithm to use?");
                System.out.println("  b - Breadth-first search");
                System.out.println("  d - Dijkstra");
                algorithm = s.nextLine();
            }
            if (algorithm.equals("d")) {
                AlgorithmInterface.setAlgorithm(new Dijkstra(GraphInterface.getGraph()));
                if (!GraphInterface.getGraph().isDirected()) {
                    System.out.println("Seems like you've chosen to run Dijkstra's\n"
                            + "algorithm on an undirected graph. It might not give\n"
                            + "expected results.");
                }
            }
        }
        AlgorithmInterface.setAlgorithm(new BreadthFirstSearch(GraphInterface.getGraph()));
    }
}
