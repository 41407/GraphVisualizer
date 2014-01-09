/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import DataStructures.BinaryHeap;
import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import Graph.Graph;
import Graph.Vertex;
import java.util.Random;

/**
 * Assigns coordinates for each vertex in graph in order to draw them on screen.
 *
 * @author 41407
 */
public class AssignCoordinates {

    /**
     * Assign starting coordinates for each vertex in graph using a very simple
     * algorithm.
     *
     * @param g
     */
    public static void initialize(Graph g) {
        Random r = new Random();
        int vertices = g.getVertices().getSize();
        int verticesPerRow = (int) Math.sqrt(vertices)+1;
        BinaryHeap<DoublyLinkedList<Vertex>> neighbours = new BinaryHeap();
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            neighbours.insert(g.getAdjacencyList().getNeighbours(i));
        }
        DynamicArray<Vertex> doneVertices = new DynamicArray();
        int i = 0;
        while (!neighbours.isEmpty()) {
            DoublyLinkedList<Vertex> neighboursToV = neighbours.delMin();
            Vertex v = neighboursToV.min();
            while (v != null) {
                if (!doneVertices.contains(v)) {
                    doneVertices.insert(v);
                    v.setLocation((i % verticesPerRow) * 100 + r.nextInt(30),
                            (i / verticesPerRow) * 100 + r.nextInt(30));
                    i++;

                }
                v = neighboursToV.succ(v);
            }
        }
        fitToSize(g, 1024, 768, 250);
    }

    /**
     * Goes through the vertices of the graph to find one with largest x value
     *
     * @param g Graph to be assessed
     * @return Largest x value in graph
     */
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

    /**
     * Goes through the vertices of the graph to find one with largest y value
     *
     * @param g Graph to be assessed
     * @return Largest y value in graph
     */
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

    private static void fitToSize(Graph g, int xSize, int ySize, int padding) {
        double xMax = findGreatestX(g);
        double yMax = findGreatestY(g);
        double xCoefficient = (xSize - padding) / xMax;
        double yCoefficient = (ySize - padding) / yMax;
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            Vertex v = g.getVertices().get(i);
            v.setLocation((int) (v.getX() * xCoefficient + padding / 2.0),
                    (int) (v.getY() * yCoefficient + padding / 2.0));
        }
    }
}
