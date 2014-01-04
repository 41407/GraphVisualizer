/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import DataStructures.DynamicArray;
import Graph.Graph;
import Graph.Vertex;

/**
 * Assigns coordinates for each vertex in graph in order to draw them on screen.
 *
 * @author 41407
 */
public class AssignCoordinates {

    /**
     * Assign starting coordinates for each vertex in graph.
     *
     * @param g
     */
    public static void initialize(Graph g) {
        int vertices = g.getVertices().getSize();
        int verticesPerRow = (int) Math.sqrt(vertices);
        for (int i = 0; i < vertices; i++) {
            Vertex v = g.getVertices().get(i);
            v.setLocation(i % verticesPerRow, i / verticesPerRow);
        }
    }

    private static int findGreatestX(Graph g) {
        DynamicArray vertices = g.getVertices();
        Vertex v = (Vertex) vertices.get(0);
        int greatest = v.getX();
        for (int i = 0; vertices.get(i) != null; i++) {
            v = (Vertex) vertices.get(i);
            if (v.getX() > greatest) {
                greatest = v.getX();
            }
        }
        return greatest;
    }

    private static int findGreatestY(Graph g) {
        DynamicArray vertices = g.getVertices();
        Vertex v = (Vertex) vertices.get(0);
        int greatest = v.getY();
        for (int i = 0; vertices.get(i) != null; i++) {
            v = (Vertex) vertices.get(i);
            if (v.getY() > greatest) {
                greatest = v.getY();
            }
        }
        return greatest;
    }
}
