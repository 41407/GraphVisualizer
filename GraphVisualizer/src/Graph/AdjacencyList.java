/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import Graph.Vertex;

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
     * Adds an edge between two vertices in adjacency list
     *
     * @param uVertex index of first vertex
     * @param vVertex index of neighbouring vertex
     */
    public void addEdge(int uVertex, int vVertex) {
        if (vVertex < adjacencyList.getSize() && uVertex < adjacencyList.getSize()
                && vVertex >= 0 && uVertex >= 0) {
            Vertex v = adjacencyList.get(vVertex).min();
            adjacencyList.get(uVertex).insertLast(v);
        }
    }

    /**
     * Removes the specified vertex from the adjacency list.
     *
     * @param index
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
}
