/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Graph.Vertex;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class BinaryHeapTest {

    private BinaryHeap h;
    private Vertex n;

    @Before
    public void setUp() {
        h = new BinaryHeap();
        n = new Vertex(0);
    }

    @Test
    public void isEmptyRetunsTrueWhenEmptyTest() {
        BinaryHeap b = new BinaryHeap();
        assertTrue(b.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseWhenNotEmptyTest() {
        BinaryHeap b = new BinaryHeap();
        b.insert(new Vertex(0));
        assertFalse(b.isEmpty());
    }

    @Test
    public void minReturnsCorrectValueAfterSingleInsert() {
        h.insert(n);
        assertEquals(n, h.min());
    }

    @Test
    public void minDoesNotRemoveValuesWhenCalled() {
        h.insert(n);
        h.min();
        assertFalse(h.isEmpty());
    }

    @Test
    public void delMineturnsCorrectValueAfterSingleInsert() {
        h.insert(n);
        assertEquals(n, h.delMin());
    }

    @Test
    public void delMinHeapIsEmptyAfterLastEntryCalled() {
        h.insert(n);
        h.delMin();
        assertTrue(h.isEmpty());
    }

    @Test
    public void delMinHeapDoesNotSomehowEraseTheWholeHeapWhenCalled() {
        h.insert(new Vertex(2));
        h.insert(new Vertex(1));
        h.delMin();
        assertFalse(h.isEmpty());
    }

    @Test
    public void delMinReturnsValuesInCorrectOrderWhenInputIsGivenInAscendingOrder() {
        for (int i = 0; i < 10; i++) {
            h.insert(new Vertex(i));
        }
        for (int i = 0; i < 10; i++) {
            assertEquals("Value retrieved " + i + "th wrong", i, h.delMin().getKey());
        }
    }

    @Test
    public void delMinReturnsValuesInCorrectOrderWhenInputIsGivenInDescendingOrder() {
        for (int i = 10; i > 0; i--) {
            h.insert(new Vertex(i));
        }
        for (int i = 1; i < 10; i++) {
            assertEquals("Value retrieved " + i + "th wrong", i, h.delMin().getKey());
        }
    }

    @Test
    public void delMinReturnsCorrectOrderWithRandomInput() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            h.insert(new Vertex(r.nextInt(5000)));
        }
        int lastValue = h.min().getKey();
        for (int i = 0; i < 100; i++) {
            int currentValue = h.delMin().getKey();
            assertTrue(lastValue <= currentValue);
            lastValue = currentValue;
        }
    }
}