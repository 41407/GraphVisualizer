/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import DataStructures.DoublyLinkedList;
import DataStructures.DynamicArray;
import Graph.Graph;
import Graph.Vertex;
import GraphDataHandler.GraphParser;
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
public class DijkstraTest {
    
    public DijkstraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    private static Graph testGraph1() {
        DynamicArray<String> m = new DynamicArray();
        m.insert("1 0");
        m.insert("0 0");
        Graph g = GraphParser.initialize(m);
        return g;
    }
    
    @Test
    public void dijkstraSimplePossible() {
        Graph g = testGraph1();
        Vertex[] expected = new Vertex[2];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = g.getVertices().get(i);
        }
        Vertex[] actual = new Vertex[2];
        
    }
}