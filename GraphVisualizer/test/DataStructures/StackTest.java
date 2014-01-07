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
public class StackTest {
    
    private Stack<Integer> s = new Stack();
    
    @Before
    public void setUp() {
    }
    
    
    @Test
    public void isEmptyReturnsTrueWhenEmpty() {
        assertTrue(s.isEmpty());
    }
    
    @Test
    public void isEmptyReturnsFalseWhenNotEmpty() {
        s.push(0);
        assertFalse(s.isEmpty());
    }
    
    @Test
    public void afterPushPopStackIsEmpty() {
        s.push(0);
        s.pop();
        assertTrue(s.isEmpty());
    }
    
    @Test
    public void singlePushPop() {
        s.push(0);
        assertTrue(0 == s.pop());
    }
    
    @Test
    public void stackReturnsValuesInCorrectOrder() {
        int[] expected = new int[100];
        for (int i = 0; i < expected.length; i++) {
            expected[99-i] = i;
            s.push(i);
        }
        int[] actual = new int[100];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = s.pop();
        }
        assertArrayEquals(expected, actual);
    }
}