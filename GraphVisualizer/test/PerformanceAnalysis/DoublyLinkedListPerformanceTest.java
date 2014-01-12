/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import DataStructures.DoublyLinkedList;
import java.util.LinkedList;
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
        for (int i = 1; i < 9; i++) {
            System.out.println("");
            printTime(testJavaLinkedListInserts(10000 * (int) Math.pow(2, i)));
            printTime(testDoublyLinkedListInserts(10000 * (int) Math.pow(2, i)));
        }
    }

    @Test
    public void deleteTest() {
        for (int i = 1; i < 9; i++) {
            System.out.println("");
            printTime(testJavaLinkedListDeletions(10000 * (int) Math.pow(2, i)));
            printTime(testDoublyLinkedListDeletions(10000 * (int) Math.pow(2, i)));
        }
    }

    @Test
    public void searchTest() {
        for (int i = 1; i < 9; i++) {
            System.out.println("");
            int[] array = initRandomArray(10000 * (int) Math.pow(2, i));
            printTime(testJavaLinkedListIndexOf(array));
            printTime(testDoublyLinkedListSearches(array));
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

    private double testJavaLinkedListDeletions(int inserts) {
        System.out.println("Testing LinkedList with " + inserts + " deletions");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            linkedList = new LinkedList();

            for (int j = 0; j < inserts; j++) {
                linkedList.add(null);
            }
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                linkedList.remove();
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

    private double testDoublyLinkedListDeletions(int inserts) {
        System.out.println("Testing DoublyLinkedList with " + inserts + " deletions");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            doublyLinkedList = new DoublyLinkedList();
            for (int j = 0; j < inserts; j++) {
                doublyLinkedList.insert(null);
            }
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                doublyLinkedList.delete();
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

    private int[] initRandomArray(int i) {
        Random r = new Random();
        int[] array = new int[i];
        for (int j = 0; j < array.length; j++) {
            array[j] = j;
        }
        /**
         * for i from n − 1 downto 1 do
         * j ← random integer with 0 ≤ j ≤ i
         * exchange a[j] and a[i]
         */
        for (int j = array.length - 1; j > 0; j--) {
            int rj = r.nextInt(array.length);
            int ar = array[rj];
            int aj = array[j];
            array[rj] = aj;
            array[j] = ar;
        }
        return array;
    }

    private double testJavaLinkedListIndexOf(int[] array) {
        System.out.println("Testing LinkedList with " + array.length + " indexOf queries");

        long[] times = new long[20];
        long startTime;
        long endTime;
        for (int i = 0; i < 20; i++) {
            linkedList = new LinkedList();
            for (int j = 0; j < array.length; j++) {
                linkedList.add(array[j]);
            }
            startTime = System.currentTimeMillis();
            for (int j = 0; j < array.length; j++) {
                linkedList.indexOf(array[j]);
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

    private double testDoublyLinkedListSearches(int[] array) {
        System.out.println("Testing DoublyLinkedList with " + array.length + " searches");

        long[] times = new long[20];
        long startTime;
        long endTime;
        for (int i = 0; i < 20; i++) {
            doublyLinkedList = new DoublyLinkedList();
            for (int j = 0; j < array.length; j++) {
                doublyLinkedList.insert(array[j]);
            }
            startTime = System.currentTimeMillis();
            for (int j = 0; j < array.length; j++) {
                doublyLinkedList.search(array[j]);
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