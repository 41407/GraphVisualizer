/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;

/**
 * An adjacency list. Not really in use at the moment
 *
 * @author 41407
 */
public class AdjacencyList {

    private DynamicArray<DoublyLinkedList<Vertex>> adjacencyList;

    public AdjacencyList() {
        this.adjacencyList = new DynamicArray();
    }

    /**
     * Adds a new vertex into the adjacency list.
     *
     * @param v Vertex to be added
     */
    public void addVertex(Vertex v) {
        DoublyLinkedList<Vertex> vertexList = new DoublyLinkedList();
        vertexList.insert(v);
        this.adjacencyList.insert(vertexList);
    }

    /**
     * Returns a DoublyLinkedList containing the neighbours of a vertex, first
     * of which is the vertex itself
     *
     * @param index index of vertex
     * @return list of parameter vertex and its neighbours
     */
    public DoublyLinkedList<Vertex> getNeighbours(int index) {
        return adjacencyList.get(index);
    }

    /**
     * Returns a DoublyLinkedList containing the neighbours of a vertex, first
     * of which is the vertex itself
     *
     * @param vertex vertex whose neighbours are to be returned
     * @return list of parameter vertex and its neighbours
     */
    public DoublyLinkedList<Vertex> getNeighbours(Vertex vertex) {
        return adjacencyList.get(indexOf(vertex));
    }

    /**
     * Adds an edge between two vertices in adjacency list
     *
     * @param start Start vertex
     * @param end End vertex
     */
    public void addEdge(Vertex start, Vertex end) {
        addEdge(indexOf(start), indexOf(end));
    }

    /**
     * Adds an edge between two vertices in adjacency list
     *
     * @param start index of first vertex
     * @param end index of neighbouring vertex
     */
    public void addEdge(int start, int end) {
        if (end < adjacencyList.getSize() && start < adjacencyList.getSize()
                && end >= 0 && start >= 0) {
            Vertex v = adjacencyList.get(end).min();
            adjacencyList.get(start).insertLast(v);
        }
    }

    /**
     * Removes the specified vertex from the adjacency list.
     *
     * @param v Vertex to be removed
     */
    public void removeVertex(Vertex v) {
        removeVertex(indexOf(v));
    }

    /**
     * Removes the vertex at specified index from the adjacency list.
     *
     * @param index Index of vertex to be removed
     */
    public void removeVertex(int index) {
        Vertex toBeRemoved = adjacencyList.get(index).min();
        for (int i = 0; i < adjacencyList.getSize(); i++) {
            Vertex v = adjacencyList.get(i).min();
            while (v != null) {
                v = adjacencyList.get(i).succ(v);
                if (v != null && v.equals(toBeRemoved)) {
                    adjacencyList.get(i).delete(v);
                    break;
                }
            }
        }
        adjacencyList.delete(index);
    }

    private int indexOf(Vertex v) {
        Vertex r = adjacencyList.get(0).min();
        for (int i = 0; i < adjacencyList.getSize(); i++) {
            r = adjacencyList.get(i).min();
            if (r.equals(v)) {
                return i;
            }
        }
        return adjacencyList.getSize();
    }
}
