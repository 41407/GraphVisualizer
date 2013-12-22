/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.PriorityQueue;

/**
 * Binary heap
 * 
 * For now, uses Java PriorityQueue to implement its features
 * 
 * @author 41407
 */
public class BinaryHeap {

    private PriorityQueue<Element> heap;

    public BinaryHeap() {
        this.heap = new PriorityQueue();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(Element n) {
        heap.add(n);
    }

    public Element min() {
        return heap.peek();
    }

    public Element delMin() {
        return heap.poll();
    }
}
