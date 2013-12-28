/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DynamicArray;

/**
 *
 * @author 41407
 */
public class Graph {

    private DynamicArray edges;
    private DynamicArray vertices;

    public Graph() {
        edges = new DynamicArray();
        vertices = new DynamicArray();
    }

    /**
     * Add vertex into graph
     *
     * @param v vertex to be added
     */
    public void addVertex(Vertex v) {
        vertices.insert(v);
    }

    /**
     * Remove vertex from graph
     *
     * @param v vertex to be removed
     */
    public void removeVertex(Vertex v) {
        vertices.delete(v);
    }

    /**
     * Add edge into graph
     *
     * @param e edge to be added
     */
    public void addEdge(Edge e) {
        edges.insert(e);
    }

    public DynamicArray getEdges() {
        return edges;
    }

    public DynamicArray getVertices() {
        return vertices;
    }
}