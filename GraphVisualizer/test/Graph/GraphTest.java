/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DynamicArray;
import DataStructures.Element;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        g.addEdge(e);
        DynamicArray a = g.getEdges();
        assertTrue(a.contains(e));
    }
}