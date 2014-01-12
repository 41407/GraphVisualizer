/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Simple dynamicArray based queue. Does not clean its beginning, so might not
 * be optimal implementation for really large inputs.
 *
 * @author 41407
 */
public class Queue<E> {

    private DynamicArray<E> queue;
    private int dequeue;

    public Queue() {
        queue = new DynamicArray();
        dequeue = 0;
    }

    /**
     * Checks if queue is empty.
     *
     * @return True if empty, false if not.
     */
    public boolean isEmpty() {
        if (dequeue == queue.getSize()) {
            return true;
        }
        return false;
    }

    /**
     * Adds parameter element at the end of the queue
     *
     * @param element Element to be added
     */
    public void enqueue(E element) {
        queue.insert(element);
    }

    /**
     * Returns and removes element that was first inserted into queue.
     *
     * @return Element that was inserted into queue first.
     */
    public E dequeue() {
        if (dequeue >= 0 && dequeue < queue.getSize()) {
            final E returnValue = (E) queue.get(dequeue);
            dequeue++;
            return returnValue;
        } else {
            return null;
        }
    }
}
