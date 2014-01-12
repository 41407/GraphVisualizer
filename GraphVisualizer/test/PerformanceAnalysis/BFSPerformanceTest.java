/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import Algorithms.BreadthFirstSearch;
import Algorithms.Dijkstra;
import Graph.Graph;
import GraphDataHandler.RandomGraph;
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
public class BFSPerformanceTest {

    public BFSPerformanceTest() {
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

    @Test
    public void testBFS() {
        for (int i = 500; i < 10000; i += 500) {
            Graph g = RandomGraph.quick(i);
            System.out.print("|V| = " + g.getVertices().getSize() + "   |E| = " + g.getEdges().getSize() + ":    ");
            double startTime;
            double endTime;
            double[] times = new double[10];
            for (int j = 0; j < 10; j++) {
                BreadthFirstSearch b = new BreadthFirstSearch(g);
                b.initialize(g.getVertices().get(g.getVertices().getSize()-1));
                startTime = System.currentTimeMillis();
                while (b.singleStep()) {
                    b.singleStep();
                }
                endTime = System.currentTimeMillis();
                times[j] = endTime - startTime;
            }
            double returnValue = 0;
            for (int j = 0; j < times.length; j++) {
                returnValue += times[j];

            }
            System.out.println(returnValue / 10.0);
        }
    }
}