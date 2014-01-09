/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.DynamicArray;
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

    private String[] test1 = {"Directed", "x 1",
        "x x"};
    private String[] test2 = {"DIrected", "x 1 x",
        "x x 1",
        "1 x x"};
    private DynamicArray<String> t1 = new DynamicArray();
    private DynamicArray<String> t2 = new DynamicArray();

    @Before
    public void setUp() {
        for (int i = 0; i < test1.length; i++) {
            t1.insert(test1[i]);
        }
        for (int i = 0; i < test2.length; i++) {
            t2.insert(test2[i]);
        }
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
        Graph g = GraphParser.initialize(t1);
        assertEquals(2, countVertices(g));
        assertEquals(1, countEdges(g));
    }

    @Test
    public void anotherSmallGraphAddedCorrectly() {
        Graph g = GraphParser.initialize(t2);
        assertEquals(3, countVertices(g));
        assertEquals(3, countEdges(g));
    }

//    @Test
//    public void bidirectionalEdgesAreNotAddedMultipleTimes() {
//        String[] b = {"x 1",
//            "1 x"};
//        DynamicArray<String> best = new DynamicArray();
//        best.insert(b[0]);
//        best.insert(b[1]);
//        Graph g = GraphParser.initialize(best);
//        assertEquals(2, countVertices(g));
//        assertEquals(1, countEdges(g));
//    }
}