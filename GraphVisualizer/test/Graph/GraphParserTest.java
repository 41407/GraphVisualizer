/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import GraphDataHandler.GraphParser;
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
public class GraphParserTest {

    private String[] test1 = {"0 1",
                              "0 0"};
    private String[] test2 = {"0 1 0",
                              "0 0 1",
                              "1 0 0"};

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Returns the number of edges in graph
     *
     * @param g
     * @return
     */
    private int countEdges(Graph g) {
        int edges = 0;
        while (g.getEdges().get(edges) != null) {
            edges++;
        }
        return edges;
    }

    /**
     * Returns the number of vertices in graph
     *
     * @param g
     * @return
     */
    private int countVertices(Graph g) {
        int vertices = 0;
        while (g.getVertices().get(vertices) != null) {
            vertices++;
        }
        return vertices;
    }

    @Test
    public void smallGraphTestAddedTwoVerticesAndOneEdge() {
        Graph g = GraphParser.initialize(test1);
        assertEquals(2, countVertices(g));
        assertEquals(1, countEdges(g));
    }

    @Test
    public void anotherSmallGraphAddedCorrectly() {
        Graph g = GraphParser.initialize(test2);
        assertEquals(3, countVertices(g));
        assertEquals(3, countEdges(g));
    }

    @Test
    public void bidirectionalEdgesAreNotAddedMultipleTimes() {
        String[] b = {"0 1",
            "1 0"};
        Graph g = GraphParser.initialize(b);
        assertEquals(2, countVertices(g));
        assertEquals(1, countEdges(g));
    }
}