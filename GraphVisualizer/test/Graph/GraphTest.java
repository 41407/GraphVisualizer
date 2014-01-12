/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DynamicArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class GraphTest {

    private Graph g;
    private Vertex v;
    private Edge e;

    @Before
    public void setUp() {
        g = new Graph();
        v = new Vertex(0);
        e = new Edge(null, null);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addingVerticesWorks() {
        g.addVertex(v);
        DynamicArray a = g.getVertices();
        assertTrue(a.contains(v));
    }

    @Test
    public void addingEdgesWorks() {
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Edge e = new Edge(a, b);
        g.addVertex(a);
        g.addVertex(b);
        g.addEdge(a, b, 1);
        assertTrue(g.getEdges().get(0).equals(e));
    }

    @Test
    public void addingEdgeBetweenVerticesOnlyAddsOneEdge() {
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Edge e = new Edge(a, b);
        g.addVertex(a);
        g.addVertex(b);
        g.addEdge(a, b, 1);
        assertEquals(1, g.getEdges().getSize());
    }

    @Test
    public void getEdgeByVertices() {
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Edge e = new Edge(a, b);
        g.addVertex(a);
        g.addVertex(b);
        g.addEdge(a, b, 1);
        assertTrue(g.getEdgeByVertices(a, b).equals(e));
    }

    @Test
    public void vertexListAndAdjacencyListContainSameObjects() {
        Vertex a = new Vertex(0);
        g.addVertex(a);
        assertEquals(a, g.getAdjacencyList().getNeighbours(0).min());
    }
}