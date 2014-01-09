/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import DataStructures.DynamicArray;
import Graph.Graph;
import Graph.Vertex;

/**
 * Finds nearest vertex in relation to an (x, y) coordinate
 *
 * @author 41407
 */
public class FindNearestVertex {

    private static double thresholdValue = 20;

    /**
     * Returns vertex closest to specified location if it's near enough (as
     * specified in FindNearestVertex.thresholdValue)
     *
     * @param g Graph to be evaluated
     * @param x x coordinate
     * @param y y coordinate
     * @return Vertex if coordinates are close enough, null if not
     */
    public static Vertex at(Graph g, int x, int y) {

        DynamicArray<Vertex> vertices = g.getVertices();
        Vertex v = vertices.get(0);
        Vertex closestVertex = v;
        double closest = Integer.MAX_VALUE;
        for (int i = 0; i < vertices.getSize(); i++) {
            v = vertices.get(i);
            double thisX = v.getX();
            double thisY = v.getY();
            if (Math.sqrt(Math.pow(Math.abs(thisX - x), 2) + Math.pow(Math.abs(thisY - y), 2)) < closest) {
                closest = Math.sqrt(Math.pow(Math.abs(thisX - x), 2) + Math.pow(Math.abs(thisY - y), 2));
                closestVertex = v;
            }
        }
        if (closest < thresholdValue) {
            return closestVertex;
        } else {
            return null;
        }
    }
}
