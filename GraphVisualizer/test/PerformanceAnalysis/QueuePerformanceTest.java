/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import DataStructures.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
public class QueuePerformanceTest {

    private Queue<Integer> queue;
    private ArrayDeque<Integer> deque;

    public QueuePerformanceTest() {
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
    public void enqueueTest() {
        for (int i = 1; i < 8; i++) {
            System.out.println("");
            printTime(testArrayDequeEnqueue(100000 * (int) Math.pow(2, i)));
            printTime(testQueueEnqueue(100000 * (int) Math.pow(2, i)));
        }
    }

    @Test
    public void dequeueTest() {
        for (int i = 1; i < 8; i++) {
            System.out.println("");
            printTime(testArrayDequeDequeue(100000 * (int) Math.pow(2, i)));
            printTime(testQueueDequeue(100000 * (int) Math.pow(2, i)));
        }
    }

    private void printTime(double time) {
        System.out.println("Average time taken: " + time + " ms");
    }

    private double testArrayDequeEnqueue(int inserts) {
        System.out.println("Testing arrayDeque with " + inserts + " pushes");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            deque = new ArrayDeque();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                deque.add(0);
            }
            endTime = System.currentTimeMillis();
            times[i] = endTime - startTime;
        }

        double returnValue = 0;
        for (int i = 0; i < times.length; i++) {
            returnValue += times[i];
        }
        return returnValue / 20.0;
    }

    private double testQueueEnqueue(int inserts) {
        System.out.println("Testing queue with " + inserts + " pushes");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            queue = new Queue();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                queue.enqueue(0);
            }
            endTime = System.currentTimeMillis();
            times[i] = endTime - startTime;
        }

        double returnValue = 0;
        for (int i = 0; i < times.length; i++) {
            returnValue += times[i];
        }
        return returnValue / 20.0;
    }

    private double testArrayDequeDequeue(int inserts) {
        System.out.println("Testing arrayDeque with " + inserts + " pushes");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            deque = new ArrayDeque();
            for (int j = 0; j < inserts; j++) {
                deque.add(0);
            }
            startTime = System.currentTimeMillis();

            for (int j = 0; j < inserts; j++) {
                deque.poll();
            }
            endTime = System.currentTimeMillis();
            times[i] = endTime - startTime;
        }

        double returnValue = 0;
        for (int i = 0; i < times.length; i++) {
            returnValue += times[i];
        }
        return returnValue / 20.0;
    }

    private double testQueueDequeue(int inserts) {
        System.out.println("Testing queue with " + inserts + " pushes");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            queue = new Queue();
            for (int j = 0; j < inserts; j++) {
                queue.enqueue(0);
            }
            startTime = System.currentTimeMillis();

            for (int j = 0; j < inserts; j++) {
                queue.dequeue();
            }
            endTime = System.currentTimeMillis();
            times[i] = endTime - startTime;
        }

        double returnValue = 0;
        for (int i = 0; i < times.length; i++) {
            returnValue += times[i];
        }
        return returnValue / 20.0;
    }
}