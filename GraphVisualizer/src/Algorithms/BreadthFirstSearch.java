/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import DataStructures.Queue;
import Graph.AdjacencyList;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;

/**
 * Simple breadth-first search algorithm.
 *
 * @author 41407
 */
public class BreadthFirstSearch implements Algorithm {

    private Graph graph;
    private AdjacencyList adjacency;
    private DynamicArray<Vertex> vertices;
    private DynamicArray<Edge> edges;
    private Queue<Vertex> queue;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.adjacency = graph.getAdjacencyList();
        this.vertices = graph.getVertices();
        this.edges = graph.getEdges();
        this.queue = new Queue();
    }

    /**
     * Initializes algorithm to start from specified vertex.
     *
     * @param start Vertex to start from.
     */
    @Override
    public void initialize(Vertex start) {
        for (int i = 0; i < edges.getSize(); i++) {
            edges.get(i).setVisited(false);
        }
        for (int i = 0; i < vertices.getSize(); i++) {
            vertices.get(i).setColor(VertexColor.WHITE);
            vertices.get(i).setDistance(Integer.MAX_VALUE);
            vertices.get(i).setPath(null);
        }
        start.setColor(VertexColor.GRAY);
        start.setDistance(0);
        queue.enqueue(start);
    }

    /**
     * Advances the algorithm by one step.
     */
    @Override
    public void singleStep() {
        if (!queue.isEmpty()) {
            Vertex u = queue.dequeue();
            DoublyLinkedList<Vertex> neighbours = adjacency.getNeighbours(u);
            Vertex v = neighbours.succ(neighbours.min());
            while (v != null) {
                if (v.getColor() == VertexColor.WHITE) {
                    v.setColor(VertexColor.GRAY);
                    v.setDistance(u.getDistance() + 1);
                    v.setPath(u);
                    graph.getEdgeByVertices(u, v).setVisited(true);
                    queue.enqueue(v);
                }
                v = neighbours.succ(v);
            }
            u.setColor(VertexColor.BLACK);
        }
    }
}
