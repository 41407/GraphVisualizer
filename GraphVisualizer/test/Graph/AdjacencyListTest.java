/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 41407
 */
public class AdjacencyListTest {

    private AdjacencyList l;
    private Vertex v;
    private Vertex k;

    @Before
    public void setUp() {
        l = new AdjacencyList();
        v = new Vertex(0);
        k = new Vertex(0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addingVerticesToEmptyList() {
        l.addVertex(v);
        assertTrue(v.equals(l.getNeighbours(0).min()));
    }

    @Test
    public void removingLastVertex() {
        l.addVertex(v);
        l.removeVertex(0);
        assertNull(l.getNeighbours(0));
    }

    @Test
    public void removingNonLastVertex() {
        l.addVertex(v);
        l.addVertex(k);
        l.removeVertex(0);
        assertTrue(l.getNeighbours(0).min().equals(k));
    }

    @Test
    public void addingSingleNeighbourToVertexByIndex() {
        l.addVertex(v);
        l.addVertex(k);
        l.addEdge(0, 1);
        assertTrue(l.getNeighbours(0).contains(v)
                && l.getNeighbours(0).contains(k));
    }

    @Test
    public void addingSingleNeighbourToVertexByVertex() {
        l.addVertex(v);
        l.addVertex(k);
        l.addEdge(v, k);
        assertTrue(l.getNeighbours(0).contains(v)
                && l.getNeighbours(0).contains(k));
    }

    @Test
    public void removingSingleVertexThatIsANeighbour() {
        l.addVertex(v);
        l.addVertex(k);
        l.addEdge(0, 1);
        l.removeVertex(1);
        assertTrue(l.getNeighbours(0).contains(v)
                && !l.getNeighbours(0).contains(k));
    }

    @Test
    public void removingSingleVertexThatHasNeighbours() {
        l.addVertex(v);
        l.addVertex(k);
        l.addEdge(0, 1);
        l.removeVertex(0);
        assertTrue(l.getNeighbours(0).contains(k)
                && !l.getNeighbours(0).contains(v));
    }
}