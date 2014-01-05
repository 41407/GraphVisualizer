/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Binary heap
 *
 * For now, uses Java PriorityQueue to implement its features
 *
 * @author 41407
 */
public class BinaryHeap<E extends Comparable<E>> {

    private DynamicArray<E> heap;
    private int heapSize;

    public BinaryHeap() {
        heap = new DynamicArray();
        heapSize = 0;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(E e) {
        heap.insert(e);
        heapSize++;
        int i = heapSize;
        while (i > 0
                && heap.get(parent(i)).compareTo(e) < 0) {
            heap.set(i, heap.get(parent(i)));
            i = parent(i);
        }
        heap.set(i, e);
    }

    public E min() {
        final E returnValue = (E) heap.get(0);
        return returnValue;
    }

    public E delMin() {
        final E returnValue = (E) heap.get(0);
        heap.delete(0);
        heapSize--;

        heapify(0);
        return returnValue;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * (i + 1) - 1;
    }

    private int right(int i) {
        return left(i)+1; // heh
    }

    private void heapify(int index) {
        int leftChild = left(index);
        int rightChild = right(index);
        E indexElement = heap.get(index);
        E leftElement = heap.get(leftChild);
        E rightElement = heap.get(rightChild);
        int smallerChild;
        if (rightChild < heapSize) {
            if (leftElement.compareTo(rightElement) < 0) {
                smallerChild = leftChild;
            } else {
                smallerChild = rightChild;
            }
            E smallerElement = heap.get(smallerChild);
            if (indexElement.compareTo(smallerElement) > 0) {
                swapElementsAtIndices(index, smallerChild);
                heapify(smallerChild);
            }
        } else if (leftChild == heapSize - 1 && indexElement.compareTo(leftElement) < 0) {
            swapElementsAtIndices(index, leftChild);
        }
    }

    private void swapElementsAtIndices(int index, int smallest) {
        E atIndex = heap.get(index);
        E atSmallest = heap.get(smallest);
        heap.set(index, atSmallest);
        heap.set(smallest, atIndex);
    }
}
