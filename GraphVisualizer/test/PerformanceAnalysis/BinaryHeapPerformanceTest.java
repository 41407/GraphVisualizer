/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import DataStructures.BinaryHeap;
import java.util.PriorityQueue;
import java.util.Random;
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
public class BinaryHeapPerformanceTest {

    private Random r;
    private BinaryHeap<Integer> binaryHeap;
    private PriorityQueue<Integer> priorityQueue;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insertTest() {
        for (int i = 1; i < 10; i++) {
            int[] inserts = initializeRandomTable(10000 * ((int) Math.pow(2, i) / 4));
            printTime(testPriorityQueueInserts(inserts));
            printTime(testBinaryHeapInserts(inserts));
        }
    }
    @Test
    public void delMaxTest() {
        for (int i = 1; i < 10; i++) {
            int[] inserts = initializeRandomTable(10000 * ((int) Math.pow(2, i) / 4));
            printTime(testPriorityQueuePoll(inserts));
            printTime(testBinaryHeapDelMin(inserts));
        }
    }

    private double testPriorityQueueInserts(int[] inserts) {
        System.out.print("Testing PriorityQueue with " + inserts.length + " inserts... ");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            priorityQueue = new PriorityQueue();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts.length; j++) {
                priorityQueue.add(inserts[j]);
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

    private double testBinaryHeapInserts(int[] inserts) {
        System.out.print("Testing BinaryHeap with " + inserts.length + " inserts... ");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            binaryHeap = new BinaryHeap();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts.length; j++) {
                binaryHeap.insert(inserts[j]);
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

    private int[] initializeRandomTable(int size) {
        r = new Random();
        System.out.println("\nGenerating random input...");
        int[] randomTable = new int[size];
        for (int i = 0; i < randomTable.length; i++) {
            randomTable[i] = r.nextInt(size);
        }
        return randomTable;
    }

    private void printTime(double time) {
        System.out.println("Average time taken: " + time + " ms");
    }

    private double testPriorityQueuePoll(int[] inserts) {
        System.out.println("Testing PriorityQueue with " + inserts.length + " polls");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            priorityQueue = new PriorityQueue();
            for (int j = 0; j < inserts.length; j++) {
                priorityQueue.add(inserts[j]);
            }
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts.length; j++) {
                priorityQueue.poll();
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

    private double testBinaryHeapDelMin(int[] inserts) {
        System.out.println("Testing BinaryHeap with " + inserts.length + " delMins");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            binaryHeap = new BinaryHeap();

            for (int j = 0; j < inserts.length; j++) {
                binaryHeap.insert(inserts[j]);
            }
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts.length; j++) {
                binaryHeap.delMin();
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