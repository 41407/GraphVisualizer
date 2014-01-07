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

    /**
     * Checks whether binary heap has any elements in it
     *
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Inserts an element into binary heap and positions it correctly.
     *
     * @param e element to be inserted
     */
    public void insert(E e) {
        heap.insert(e);
        heapSize++;
        int i = heapSize;
        while (i > 0 && heap.get(parent(i)).compareTo(e) > 0) {
            swapElementsByIndex(i, parent(i));
            i = parent(i);
        }
        heap.set(i, e);
    }

    /**
     * Retrieves the element with smallest key without removing it from the
     * heap.
     *
     * @return Element with smallest key.
     */
    public E min() {
        final E returnValue = (E) heap.get(0);
        return returnValue;
    }

    /**
     * Retrieves and deletes the element with smallest key from heap and
     * reorganizes the heap.
     *
     * @return Element with smallest key.
     */
    public E delMin() {
        final E returnValue = (E) heap.get(0);
        heap.delete(0);
        heapSize--;
        heapify(0);
        return returnValue;
    }

    /**
     * Used to retrieve the index of the parent of parameter entry
     *
     * @param i index of specified element
     * @return index of its parent
     */
    private int parent(int i) {
        i += 1;
        return i / 2 - 1;
    }

    /**
     * Used to retrieve the left hand child of parameter entry
     *
     * @param i index of specified element
     * @return index of its left child
     */
    private int left(int i) {
        i += 1;
        return 2 * i - 1;
    }

    /**
     * Used to retrieve the right hand child of parameter entry
     *
     * @param i index of specified element
     * @return index of its right child
     */
    private int right(int i) {
        return left(i) + 1;
    }

    /**
     * Creates a heap out of given array of elements
     *
     * @param indexOfParent From which index to start heapifyin'
     */
    private void heapify(int indexOfParent) {
        int indexOfLeftChild = left(indexOfParent);
        int indexOfRightChild = right(indexOfParent);
        int indexOfSmallerChild;
        E parent = heap.get(indexOfParent);
        E leftChild = heap.get(indexOfLeftChild);
        E rightChild = heap.get(indexOfRightChild);
        E smallerChild;
        if (leftChild != null) {
            if (rightChild != null) {
                if (leftChild.compareTo(rightChild) < 0) {
                    indexOfSmallerChild = indexOfLeftChild;
                } else {
                    indexOfSmallerChild = indexOfRightChild;
                }
            } else {
                indexOfSmallerChild = indexOfLeftChild;
            }
            smallerChild = heap.get(indexOfSmallerChild);
            if (parent.compareTo(smallerChild) > 0) {
                swapElementsByIndex(indexOfParent, indexOfSmallerChild);
                heapify(indexOfSmallerChild);
            }
        }
    }

    /**
     * Swaps elements in parameter indices
     *
     * @param firstIndex
     * @param secondIndex
     */
    private void swapElementsByIndex(int firstIndex, int secondIndex) {
        E firstKey = heap.get(firstIndex);
        E secondKey = heap.get(secondIndex);
        heap.set(firstIndex, secondKey);
        heap.set(secondIndex, firstKey);
    }
}
