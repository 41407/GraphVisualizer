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

    private boolean directed;
    private DynamicArray<Vertex> vertices;
    private DynamicArray<Edge> edges;
    private AdjacencyList adjacencyList;

    public Graph() {
        edges = new DynamicArray();
        vertices = new DynamicArray();
        adjacencyList = new AdjacencyList();
        this.directed = false;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
        for (int i = 0; i < edges.getSize(); i++) {
            edges.get(i).setDirected(directed);
        }
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
        adjacencyList.addVertex(v);
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
        adjacencyList.removeVertex(v);
    }

    /**
     * Add edge between two vertices in graph.
     *
     * @param start Start vertex of edge
     * @param end End vertex of edge
     */
    public void addEdge(Vertex start, Vertex end, int weight) {
        if (graphContainsVertex(start) && graphContainsVertex(end)) {
            edges.insert(new Edge(start, end, weight, this.directed));
            if (start != end) {
                adjacencyList.addEdge(start, end);
            }
        }
    }

    /**
     * Finds the edge with parameter start and end vertices if it exists.
     *
     * @param start Start vertex
     * @param end End vertex
     * @return Edge between parameter vertices if it exists, null if not
     */
    public Edge getEdgeByVertices(Vertex start, Vertex end) {
        for (int i = 0; i < edges.getSize(); i++) {
            if (edges.get(i).getStart() == start) {
                if (edges.get(i).getEnd() == end) {
                    return edges.get(i);
                }
            }
        }
        return null;
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

    public AdjacencyList getAdjacencyList() {
        return adjacencyList;
    }
}