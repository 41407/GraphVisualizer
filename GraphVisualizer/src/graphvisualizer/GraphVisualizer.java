/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphvisualizer;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String file = "Don't judge me!";
        String cheesyPrompt = "Which file to read graph from?";
        Graph g;
        while (!file.equals("quit")) {
            try {
                g = GraphParser.initialize(FileLoader.loadFile("src/" + file + ".txt"));
                AssignCoordinates.initialize(g);
                GraphInterface.setGraph(g);
                AlgorithmInterface.setDijkstra(new Dijkstra(g));
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
