/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Graph.Vertex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class DynamicArrayTest {

    private DynamicArray<Vertex> a;
    private Vertex v = new Vertex(0, 0);

    @Before
    public void setUp() {
        a = new DynamicArray();
    }

    @Test
    public void singleInsertSizeAndContent() {
        a.insert(v);
        assertEquals(v, a.get(0));
        assertEquals(1, a.getSize());
    }

    @Test
    public void singleDeleteSizeAndContent() {
        a.insert(v);
        a.delete(v);
        assertNull(a.get(0));
        assertEquals(0, a.getSize());
    }

    @Test
    public void singleDeleteByIndexSizeAndContent() {
        a.insert(v);
        a.delete(0);
     //   assertNull(a.get(0));
        assertEquals(0, a.getSize());
    }

    @Test
    public void deletingFromEmptyListDoesntAffectSize() {
        a.delete(v);
        assertEquals(0, a.getSize());
        for (int i = 0; i < 10; i++) {
            a.delete(v);
        }
        assertEquals(0, a.getSize());
    }

    @Test
    public void multipleInsertsHasCorrectOrder() {
        for (int i = 0; i < 10; i++) {
            a.insert(new Vertex(0, i));
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, a.get(i).getDistance());
        }
    }

    @Test
    public void setReplacesCorrectElement() {
        a.insert(v);
        a.set(0, new Vertex(0, 149));
        assertEquals(149, a.get(0).getDistance());
    }

    @Test
    public void getIndexOutOfBoundsReturnsNull() {
        a.insert(v);
        assertEquals(null, a.get(Integer.MAX_VALUE));
        assertEquals(null, a.get(-1));
    }

    @Test
    public void containsReturnsTrueWhenElementInArray() {
        a.insert(v);
        assertTrue(a.contains(v));
    }

    @Test
    public void containsReturnsFalseWhenElementNotInArray() {
        a.insert(new Vertex(493));
        assertFalse(a.contains(v));
    }
    
    @Test
    public void manyInsertsResizesArray() {
        String expected = "";
        for (int i = 0; i < 100; i++) {
            a.insert(new Vertex(i));
            expected += i + " ";
        }
        String actual = "";
        for (int i = 0; i < 100; i++) {
            actual += a.get(i).getId() + " ";
        }
        assertEquals(expected, actual);
    }
}