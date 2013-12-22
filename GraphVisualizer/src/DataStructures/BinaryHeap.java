/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.PriorityQueue;

/**
 * Binary heap
 * 
 * @author 41407
 */
public class BinaryHeap {

    private PriorityQueue<Node> heap;

    public BinaryHeap() {
        this.heap = new PriorityQueue();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(Node n) {
        heap.add(n);
    }

    public Node min() {
        return heap.peek();
    }

    public Node delMin() {
        return heap.poll();
    }
}
