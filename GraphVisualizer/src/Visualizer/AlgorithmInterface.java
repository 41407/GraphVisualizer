/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import Algorithms.Dijkstra;

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

    public static Dijkstra getDijkstra() {
        return d;
    }
}
