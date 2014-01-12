/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import Algorithms.Dijkstra;
import Graph.Graph;
import GraphDataHandler.GraphParser;
import GraphDataHandler.RandomGraph;
import java.util.PriorityQueue;
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
public class DijkstraPerformanceTest {

    public DijkstraPerformanceTest() {
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
    public void testDijkstra() {
        for (int i = 100; i < 4000; i+= 100) {
            Graph g = RandomGraph.quick(i);
            System.out.print("|V| = " + g.getVertices().getSize() + "   |E| = " + g.getEdges().getSize() + ":    ");
            double startTime;
            double endTime;
            double[] times = new double[20];
            for (int j = 0; j < 20; j++) {
                Dijkstra d = new Dijkstra(g);
                d.initialize(g.getVertices().get(0));
                startTime = System.currentTimeMillis();
                while (d.singleStep()) {
                    d.singleStep();
                }
                endTime = System.currentTimeMillis();
                times[j] = endTime - startTime;
            }
            double returnValue = 0;
            for (int j = 0; j < times.length; j++) {
                returnValue += times[j];

            }
            System.out.println(returnValue / 20.0);
        }
    }
}