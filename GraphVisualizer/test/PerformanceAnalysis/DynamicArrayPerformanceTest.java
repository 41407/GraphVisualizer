/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PerformanceAnalysis;

import DataStructures.DynamicArray;
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
public class DynamicArrayPerformanceTest {

    private DynamicArray<Integer> dynamicArray;
    private ArrayList<Integer> arrayList;

    @Before
    public void setUp() {
        dynamicArray = new DynamicArray();
        arrayList = new ArrayList();
    }

    @Test
    public void insertTest() {
        for (int i = 1; i < 8; i++) {
            System.out.println("");
            printTime(testArrayListInserts(100000 * (int) Math.pow(2, i)));
            printTime(testDynamicArrayInserts(100000 * (int) Math.pow(2, i)));
        }
    }

    private void printTime(double time) {
        System.out.println("Average time taken: " + time + " ms");
    }

    private double testArrayListInserts(int inserts) {
        System.out.println("Testing arrayList with " + inserts + " inserts");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            arrayList = new ArrayList();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                arrayList.add(null);
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

    private double testDynamicArrayInserts(int inserts) {
        System.out.println("Testing dynamicArray with " + inserts + " inserts");

        long[] times = new long[20];
        long startTime;
        long endTime;

        for (int i = 0; i < 20; i++) {
            dynamicArray = new DynamicArray();
            startTime = System.currentTimeMillis();
            for (int j = 0; j < inserts; j++) {
                dynamicArray.insert(null);
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