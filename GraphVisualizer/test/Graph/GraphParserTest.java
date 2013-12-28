/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

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
        "1 0"};
    
    private String[] test2 = {"0 0 1",
        "1 0 1",
        "1 1 0"};

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void smallGraphTestAddedTwoVerticesAndOneEdge() {
        Graph g = GraphParser.initialize(test1);
        assertNotNull(g.getVertices().get(0));
        assertNotNull(g.getVertices().get(1));
        assertNull(g.getVertices().get(2));
        assertNotNull(g.getEdges().get(0));
        assertNull(g.getEdges().get(1));
    }
}