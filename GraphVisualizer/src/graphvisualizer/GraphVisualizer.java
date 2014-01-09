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
import UserInterface.UILogic;
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
public class GraphVisualizer {

    private static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        filePrompt();
    }

    private static void algorithmPrompt() {
        String algorithm = "";
        while (!algorithm.equals("d") && !algorithm.equals("b")) {
            System.out.println("Which algorithm to use?");
            System.out.println("  b - Breadth-first search");
            System.out.println("  d - Dijkstra");
            algorithm = s.nextLine();
        }
        if (algorithm.equals("d")) {
            AlgorithmInterface.setAlgorithm(new Dijkstra(GraphInterface.getGraph()));
        } else {
            AlgorithmInterface.setAlgorithm(new BreadthFirstSearch(GraphInterface.getGraph()));
        }
    }

    private static void filePrompt() {
        String file = "Don't judge me!";
        String cheesyPrompt = "Which file to read graph from?";
        Graph g;
        while (!file.equals("quit")) {
            try {
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
            }

        }

    }
}
