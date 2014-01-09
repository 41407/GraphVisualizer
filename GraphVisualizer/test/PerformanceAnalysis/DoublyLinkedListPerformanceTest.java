/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import DataStructures.DoublyLinkedList;
import java.util.LinkedList;
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
public class DoublyLinkedListPerformanceTest {

    private LinkedList<Integer> linkedList;
    private DoublyLinkedList<Integer> doublyLinkedList;

    public DoublyLinkedListPerformanceTest() {
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

    @Test
    public void insertTest() {
        for (int i = 1; i < 8; i++) {
            System.out.println("");
            printTime(testJavaLinkedListInserts(10000 * (int) Math.pow(2, i)));
            printTime(testDoublyLinkedListInserts(10000 * (int) Math.pow(2, i)));
        }
    }

    private void printTime(double time) {
        System.out.println("Average time taken: " + time + " ms");
    }

    private double testJavaLinkedListInserts(int inserts) {
        System.out.println("Testing LinkedList with " + inserts + " inserts");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            linkedList = new LinkedList();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                linkedList.add(null);
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

    private double testDoublyLinkedListInserts(int inserts) {
        System.out.println("Testing DoublyLinkedList with " + inserts + " inserts");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            doublyLinkedList = new DoublyLinkedList();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                doublyLinkedList.insert(null);
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