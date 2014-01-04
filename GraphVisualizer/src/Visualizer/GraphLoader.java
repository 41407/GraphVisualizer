/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import Graph.Graph;
import java.util.logging.Logger;

/**
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
