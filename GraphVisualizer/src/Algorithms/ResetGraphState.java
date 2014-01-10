/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Graph.Graph;
import Graph.Vertex;

/**
 *
 * @author 41407
 */
public class ResetGraphState implements Algorithm{
    private final Graph graph;

    public ResetGraphState(Graph g) {
        this.graph = g;
        for (int i = 0; i < g.getEdges().getSize(); i++) {
            g.getEdges().get(i).setVisited(false);
        }
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            g.getVertices().get(i).setColor(VertexColor.BLACK);
            g.getVertices().get(i).setDistance(0);
        }
    }

    
    
    @Override
    public void initialize(Vertex start) {
    }

    @Override
    public void singleStep() {
    } 
}
