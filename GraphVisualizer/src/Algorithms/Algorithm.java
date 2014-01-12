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
    public void initialize(Vertex start);
    public boolean singleStep();
}
