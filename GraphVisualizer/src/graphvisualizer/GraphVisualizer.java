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

/**
 *
 * @author 41407
 */
public class GraphVisualizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = GraphParser.initialize(FileLoader.loadFile("src/graph.txt"));
        AssignCoordinates.initialize(g);
        GraphInterface.setGraph(g);
        AlgorithmInterface.setDijkstra(new Dijkstra(g, g.getVertices().get(0)));
        UILogic.start();
    }
}
