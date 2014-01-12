/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;

/**
 * A list that contains information about Graph's edges. Vertex whose
 * neighbours are contained within its linkedList of neighbours is stored as the
 * head (min) value of its linkedList.
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
        DoublyLinkedList<Vertex> neighbours = new DoublyLinkedList();
        neighbours.insertLast(v);
        this.adjacencyList.insert(neighbours);
    }

    /**
     * Returns a DoublyLinkedList containing the neighbours of a vertex, first
     * of which is the vertex itself
     *
     * @param index index of vertex
     * @return list of parameter vertex and its neighbours, or null if out of
     * bounds
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
        adjacencyList.get(indexOf(start)).insertLast(end);
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

    /**
     * Returns index of parameter vertex.
     * 
     * @param v Vertex whose index is to be returned.
     * @return Index of parameter vertex.
     */
    private int indexOf(Vertex v) {
        Vertex r;
        if (v != null) {
            for (int i = 0; i < adjacencyList.getSize(); i++) {
                r = adjacencyList.get(i).min();
                if (r != null) {
                    if (r.equals(v)) {
                        return i;
                    }
                }
            }
        }
        return adjacencyList.getSize();
    }
}
