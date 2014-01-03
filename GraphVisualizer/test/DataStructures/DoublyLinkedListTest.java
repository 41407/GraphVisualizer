/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Graph.Vertex;
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
public class DoublyLinkedListTest {

    private DoublyLinkedList<Vertex> l;
    private Vertex v = new Vertex(0, 0);
    private Vertex a = new Vertex(0, 0);
    private Vertex b = new Vertex(0, 0);
    private Vertex c = new Vertex(0, 0);

    @Before
    public void setUp() {
        l = new DoublyLinkedList();
    }

    @Test
    public void emptyListReturnsCorrectValues() {
        assertNull(l.min());
        assertNull(l.max());
        assertNull(l.pred(a));
        assertNull(l.succ(a));
        assertFalse(l.contains(a));
    }

    @Test
    public void insertSingleElementToAnEmptyListMinMax() {
        l.insert(v);
        assertEquals(v, l.min());
        assertEquals(v, l.max());
    }

    @Test
    public void insertAddsAtTheBeginningOfList() {
        l.insert(a);
        l.insert(b);
        assertEquals(b, l.min());
    }

    @Test
    public void MinMaxWithMultipleInserts() {
        l.insert(b);
        for (int i = 0; i < 10; i++) {
            l.insert(v);
        }
        l.insert(a);
        assertEquals(a, l.min());
        assertEquals(b, l.max());
    }

    @Test
    public void containsReturnsCorrectly() {
        for (int i = 0; i < 5; i++) {
            l.insert(v);
        }
        l.insert(a);
        for (int i = 0; i < 5; i++) {
            l.insert(v);
        }
        assertTrue(l.contains(a));
        assertFalse(l.contains(b));
    }

    @Test
    public void insertMultipleElementsContains() {
        for (int i = 0; i < 5; i++) {
            l.insert(v);
        }
        l.insert(a);
        for (int i = 0; i < 5; i++) {
            l.insert(v);
        }
        assertTrue(l.contains(a));
    }

    @Test
    public void succReturnsCorrectValue() {
        l.insert(b);
        l.insert(a);
        assertEquals(b, l.succ(a));
        assertEquals(null, l.succ(b));
    }

    @Test
    public void predReturnsCorrectValue() {
        l.insert(b);
        l.insert(a);
        assertEquals(a, l.pred(b));
        assertEquals(null, l.pred(a));
    }

    private void intializeWithABC() {
        l.insert(c);
        l.insert(b);
        l.insert(a);
    }

    @Test
    public void deleteWorksAtBeginning() {
        intializeWithABC();
        l.delete(a);
        assertEquals(b, l.min());
        assertEquals(null, l.pred(b));
    }

    @Test
    public void deleteWorksAtEnd() {
        intializeWithABC();
        l.delete(c);
        assertEquals(b, l.max());
        assertEquals(null, l.succ(b));
    }

    @Test
    public void deleteWorksAtMiddle() {
        intializeWithABC();
        l.delete(b);
        assertEquals(a, l.pred(c));
        assertEquals(c, l.succ(a));
    }
}