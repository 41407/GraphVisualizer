/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import Algorithms.Dijkstra;
import Graph.Vertex;

/**
 * Static class to store an algorithm. Used as an interface between UI elements
 * and algorithm logic to reduce complexity.
 *
 * @author 41407
 */
public class AlgorithmInterface {

    private static Dijkstra d;

    public static void setDijkstra(Dijkstra d) {
        AlgorithmInterface.d = d;
    }
    
    public static void startDijkstra(Vertex start) {
        d.initialize(start);
    }

    public static Dijkstra getDijkstra() {
        return d;
    }
}
