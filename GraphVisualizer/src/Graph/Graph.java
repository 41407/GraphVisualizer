/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;

/**
 * Graph that contains vertices and edges.
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
     * Remove vertex from graph.
     *
     * TODO handle adjacencyList
     *
     * @param v vertex to be removed
     */
    public void removeVertex(Vertex v) {
        vertices.delete(v);
    }

    /**
     * Add edge between two vertices in graph.
     *
     * @param start Start vertex of edge
     * @param end End vertex of edge
     */
    public void addEdge(Vertex start, Vertex end) {
        if (graphContainsVertex(start) && graphContainsVertex(end)) {
            
            /**
             * Insert edge into list of edges
             */
            edges.insert(new Edge(start, end));
            
            /**
             * Insert edge into adjacency list
             */
            for (int i = 0; i < adjacencyList.getSize(); i++) {
                Vertex v = adjacencyList.get(i).min();
                if(v.equals(start)) {
                    adjacencyList.get(i).insertLast(end);
                    break;
                }
            }
        }
    }

    public DynamicArray<Edge> getEdges() {
        return edges;
    }

    public DynamicArray<Vertex> getVertices() {
        return vertices;
    }

    private boolean graphContainsVertex(Vertex vertex) {
        return vertices.contains(vertex);
    }

    private boolean graphContainsEdge(Edge edge) {
        return edges.contains(edge);
    }
}