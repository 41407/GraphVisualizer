/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class VertexTest {
        
    @Test
    public void TwoVerticesCompareCorrectly() {
        Vertex v = new Vertex(1);
        Vertex w = new Vertex(1);
        Vertex u = new Vertex(2);
        assertTrue(v.compareTo(u) < 0);
        assertTrue(u.compareTo(v) > 0);
        assertTrue(w.compareTo(v) == 0);
    }
}