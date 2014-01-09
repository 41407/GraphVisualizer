/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import Algorithms.Algorithm;
import Graph.Vertex;

/**
 * Static class to store an algorithm. Used as an interface between UI elements
 * and algorithm logic to reduce complexity.
 *
 * @author 41407
 */
public class AlgorithmInterface {

    private static Algorithm algorithm;

    public static void setAlgorithm(Algorithm a) {
        AlgorithmInterface.algorithm = a;
    }
    
    public static void startAlgorithm(Vertex start) {
        algorithm.initialize(start);
    }

    public static Algorithm getAlgorithm() {
        return algorithm;
    }
}
