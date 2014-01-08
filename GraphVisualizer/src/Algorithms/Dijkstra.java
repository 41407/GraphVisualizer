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
    private Vertex start;
    private BinaryHeap<Vertex> heap;

    public Dijkstra(Graph graph, Vertex start) {
        this.graph = graph;
        this.adjacency = graph.getAdjacencyList();
        this.vertices = graph.getVertices();
        this.start = start;
        this.heap = new BinaryHeap();
        initializeSingleSource(start);
        for (int i = 0; i < graph.getVertices().getSize(); i++) {
            heap.insert(graph.getVertices().get(i));
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
            DoublyLinkedList<Vertex> neighbours = adjacency.getNeighbours(u);
            Vertex v = neighbours.succ(neighbours.min());
            while (v != null) {
                relax(u, v, graph.getEdgeByVertices(u, v));
                v = neighbours.succ(v);
            }
        }
    }

    private void initializeSingleSource(Vertex start) {
        for (int i = 0; i < vertices.getSize(); i++) {
            vertices.get(i).setDistance(Integer.MAX_VALUE);
            vertices.get(i).setPath(null);
        }
        int indexOfStart = vertices.indexOf(start);
        vertices.get(indexOfStart).setDistance(0);
    }

    private void relax(Vertex u, Vertex v, Edge uv) {
        if (v.getDistance() > u.getDistance() + uv.getWeight()) {
            v.setDistance(u.getDistance() + uv.getWeight());
            v.setPath(u);
        }
    }
}
