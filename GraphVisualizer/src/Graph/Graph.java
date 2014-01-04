/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;

/**
 *
 * @author 41407
 */
public class Graph {

    private DynamicArray<Vertex> vertices;
    private DynamicArray<Edge> edges;
    private DynamicArray<DoublyLinkedList<Vertex>> adjacencyList;

    public Graph() {
        edges = new DynamicArray();
        vertices = new DynamicArray();
        adjacencyList = new DynamicArray();
    }

    /**
     * Add vertex into graph
     *
     * @param v vertex to be added
     */
    public void addVertex(Vertex v) {
        DoublyLinkedList<Vertex> vList = new DoublyLinkedList();
        vList.insert(v);
        vertices.insert(v);
        adjacencyList.insert(vList);
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
     * Add edge into graph. Tests to see if the reversed version of the
     * parameter edge already exists. If it does, sets the edge undirected.
     *
     * @param e edge to be added
     */
    public void addEdge(Edge e) {
        int i = 0;
        boolean reverseFound = false;
        while (edges.get(i) != null) {
            Edge w = edges.get(i);
            if (w.isReverseOf(e)) {
                w.setDirected(false);
                edges.set(i, w);
                edges.delete(e);
                reverseFound = true;
            }
            i++;
        }
        if (!reverseFound) {
            edges.insert(e);
        }
    }

    public DynamicArray<Edge> getEdges() {
        return edges;
    }

    public DynamicArray<Vertex> getVertices() {
        return vertices;
    }
}