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

    private DynamicArray a;
    private Vertex v = new Vertex(0);

    @Before
    public void setUp() {
        a = new DynamicArray();
    }

    @Test
    public void singleInsert() {
        a.insert(v);
        assertEquals(v, a.get(0));
    }

    @Test
    public void multipleInsertsHasCorrectOrder() {
        for (int i = 0; i < 10; i++) {
            a.insert(new Vertex(i));
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, a.get(i).getKey());
        }
    }

    @Test
    public void deleteSingleEntry() {
        a.insert(v);
        a.delete(0);
        assertEquals(null, a.get(0));
    }

    @Test
    public void deleteFromListWithMultipleEntries() {
        for (int i = 0; i < 10; i++) {
            a.insert(v);
        }
        a.delete(3);
        assertEquals(null, a.get(3));
    }

    @Test
    public void setReplacesCorrectElement() {
        a.insert(v);
        a.set(0, new Vertex(149));
        assertEquals(149, a.get(0).getKey());
    }

    @Test
    public void getIndexOutOfBoundsReturnsNull() {
        a.insert(v);
        assertEquals(null, a.get(Integer.MAX_VALUE));
        assertEquals(null, a.get(-1));
    }
}