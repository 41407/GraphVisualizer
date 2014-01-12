/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Graph.Vertex;

/**
 * Interface for algorithms.
 *
 * @author 41407
 */
public interface Algorithm {

    /**
     * Initializes the algorithm and its starting vertex.
     *
     * @param start Vertex to start algorithm from.
     */
    public void initialize(Vertex start);

    /**
     * Runs the algorithm for one step.
     *
     * @return true if algorithm would continue running if called again, false
     * if not.
     */
    public boolean singleStep();
}
