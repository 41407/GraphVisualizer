/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphvisualizer;

import Graph.Graph;
import Graph.GraphParser;
import UserInterface.UILogic;
import Visualizer.AssignCoordinates;
import Visualizer.GraphLoader;

/**
 *
 * @author 41407
 */
public class GraphVisualizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] graphString = {"0 1 0 1 0",
                              "1 0 0 0 1",
                            "1 0 0 0 0",
                            "0 0 1 0 0",
                              "1 0 1 0 0"};
        Graph g = GraphParser.initialize(graphString);
        AssignCoordinates.initialize(g);
        GraphLoader.setGraph(g);
        UILogic.start();
    }
}
