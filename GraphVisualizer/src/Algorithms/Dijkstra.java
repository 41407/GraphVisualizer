/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import DataStructures.BinaryHeap;
import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import Graph.AdjacencyList;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;

/**
 * Dijkstra's algorithm.
 *
 * @author 41407
 */
public class Dijkstra {

    private Graph graph;
    private AdjacencyList adjacency;
    private DynamicArray<Vertex> vertices;
    private DynamicArray<Edge> edges;
    private BinaryHeap<Vertex> heap;

    public Dijkstra(Graph graph) {
        this.graph = graph;
        this.adjacency = graph.getAdjacencyList();
        this.vertices = graph.getVertices();
        this.edges = graph.getEdges();
        this.heap = new BinaryHeap();
    }

    /**
     * Initializes the algorithm to start from parameter vertex
     *
     * @param start Vertex to start from
     */
    public void initialize(Vertex start) {
        initializeSingleSource(start);
        for (int i = 0; i < vertices.getSize(); i++) {
            heap.insert(vertices.get(i));
        }
        for (int i = 0; i < edges.getSize(); i++) {
            edges.get(i).setVisited(false);
        }
    }

    /**
     * Slow single step version of the algorithm to be used during graphical
     * presentation.
     *
     * Does one iteration of Dijkstra's algorithm.
     */
    public void singleStep() {
        if (!heap.isEmpty()) {
            Vertex u = heap.delMin();
            u.setColor(VertexColor.GRAY);
            DoublyLinkedList<Vertex> neighbours = adjacency.getNeighbours(u);
            Vertex v = neighbours.succ(neighbours.min());
            while (v != null) {

                relax(u, v, graph.getEdgeByVertices(u, v));
                v = neighbours.succ(v);

            }
            u.setColor(VertexColor.BLACK);
        }
    }

    private void initializeSingleSource(Vertex start) {
        for (int i = 0; i < vertices.getSize(); i++) {
            vertices.get(i).setColor(VertexColor.WHITE);
            vertices.get(i).setDistance(Integer.MAX_VALUE);
            vertices.get(i).setPath(null);
        }
        int indexOfStart = vertices.indexOf(start);
        vertices.get(indexOfStart).setDistance(0);
        vertices.get(indexOfStart).setColor(VertexColor.GRAY);
    }

    private void relax(Vertex u, Vertex v, Edge uv) {
        if (u.getDistance() < Integer.MAX_VALUE) {
            if (v.getDistance() > u.getDistance() + uv.getWeight()) {
                v.setDistance(u.getDistance() + uv.getWeight());
                v.setPath(u);
                heap.updateDecreasedElement(v);
                v.setColor(VertexColor.GRAY);
                uv.setVisited(true);
            }
        }
    }
}
