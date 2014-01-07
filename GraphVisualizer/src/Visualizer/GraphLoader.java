/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import Graph.Graph;

/**
 * Static class to store a graph. Used as an interface between UI elements and
 * graph logic to reduce complexity.
 * 
 * @author 41407
 */
public class GraphLoader {
    private static Graph g;

    public static void setGraph(Graph g) {
        GraphLoader.g = g;
    }

    public static Graph getGraph() {
        return g;
    }
}