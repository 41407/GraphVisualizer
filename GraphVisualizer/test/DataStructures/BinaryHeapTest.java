/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Graph.Vertex;
import java.util.Arrays;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class BinaryHeapTest {

    private BinaryHeap<Vertex> h;
    private Vertex v;

    @Before
    public void setUp() {
        h = new BinaryHeap();
        v = new Vertex(0, 0);
    }

    @Test
    public void isEmptyRetunsTrueWhenEmptyTest() {
        BinaryHeap b = new BinaryHeap();
        assertTrue(b.isEmpty());
    }

    @Test
    public void isEmptyReturnsFalseWhenNotEmptyTest() {
        BinaryHeap b = new BinaryHeap();
        b.insert(new Vertex(0, 0));
        assertFalse(b.isEmpty());
    }

    @Test
    public void minReturnsNullWhenHeapIsEmpty() {
        assertEquals(null, h.min());
    }

    @Test
    public void minReturnsCorrectValueAfterSingleInsert() {
        h.insert(v);
        assertEquals(v, h.min());
    }

    @Test
    public void minDoesNotRemoveValuesWhenCalled() {
        h.insert(v);
        h.min();
        assertFalse(h.isEmpty());
    }

    @Test
    public void insertKeepsMinimumValueAtTop() {
        int minimumValue = Integer.MAX_VALUE;
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            int thisValue = r.nextInt(5000);
            h.insert(new Vertex(0, thisValue));
            if(thisValue < minimumValue) {
                minimumValue = thisValue;
            }
            assertEquals(minimumValue, h.min().getDistance());
        }
    }

    @Test
    public void delMinReturnsCorrectValueAfterSingleInsert() {
        h.insert(v);
        assertEquals(v, h.delMin());
    }

    @Test
    public void delMinHeapIsEmptyAfterLastEntryCalled() {
        h.insert(v);
        h.delMin();
        assertTrue(h.isEmpty());
    }

    @Test
    public void delMinHeapDoesNotSomehowEraseTheWholeHeapWhenCalled() {
        h.insert(v);
        h.insert(v);
        h.delMin();
        assertFalse(h.isEmpty());
    }

    @Test
    public void delMinReturnsValuesInCorrectOrderWhenInputIsGivenInAscendingOrder() {
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            h.insert(new Vertex(0, i));
            expected[i] = i;
        }
        Arrays.sort(expected);
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = h.delMin().getDistance();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void delMinReturnsValuesInCorrectOrderWhenInputIsGivenInDescendingOrder() {
        int[] expected = new int[100];
        for (int i = 99; i >= 0; i--) {
            h.insert(new Vertex(0, i));
            expected[i] = i;
        }
        Arrays.sort(expected);
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = h.delMin().getDistance();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void delMinReturnsCorrectOrderWithRandomInput() {
        Random r = new Random();
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            int randomInteger = r.nextInt(5000);
            h.insert(new Vertex(0, randomInteger));
            expected[i] = randomInteger;
        }
        Arrays.sort(expected);
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = h.delMin().getDistance();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void delMinReturnsCorrectOrderWithRandomNegativeInput() {
        Random r = new Random();
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            int randomInteger = r.nextInt(5000) - 10000;
            h.insert(new Vertex(0, randomInteger));
            expected[i] = randomInteger;
        }
        Arrays.sort(expected);
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = h.delMin().getDistance();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void delMinReturnsCorrectOrderWithManyIdenticalElements() {
        Random r = new Random();
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            int randomInteger = r.nextInt(4);
            h.insert(new Vertex(0, randomInteger));
            expected[i] = randomInteger;
        }
        Arrays.sort(expected);
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = h.delMin().getDistance();
        }
        assertArrayEquals(expected, actual);
    }
}