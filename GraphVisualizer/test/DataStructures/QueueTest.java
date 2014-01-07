/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

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
public class QueueTest {
    
    private Queue<Integer> q;
    
    @Before
    public void setUp() {
        q = new Queue();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void isEmptyReturnsTrueWhenEmpty() {
        assertTrue(q.isEmpty());
    }
    
    @Test
    public void isEmptyReturnsFalseAfterSingleEnqueue() {
        q.enqueue(0);
        assertFalse(q.isEmpty());
    }
    
    @Test
    public void isEmptyReturnsTrueAfterEnqueueDequeue() {
        q.enqueue(0);
        q.dequeue();
        assertTrue(q.isEmpty());
    }
    
    @Test
    public void singleEnqueueDequeueReturnsCorrectValue() {
        q.enqueue(0);
        assertTrue(0 == q.dequeue());
    }
    
    @Test
    public void dequeueReturnsObjectsInCorrectOrder() {
        int[] expected = new int[100];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i;
            q.enqueue(i);
        }
        int[] actual = new int[100];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = q.dequeue();
        }
        assertArrayEquals(expected, actual);
    }
}