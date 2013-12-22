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
public class EdgeTest {

    @Test
    public void TwoEdgesCompareCorrectly() {
        Edge e = new Edge(null, null);
        Edge f = new Edge(null, null);
        Edge g = new Edge(null, null);
        e.setWeight(1);
        f.setWeight(1);
        g.setWeight(2);
        assertTrue(e.compareTo(g) < 0);
        assertTrue(g.compareTo(e) > 0);
        assertTrue(e.compareTo(f) == 0);
    }
}