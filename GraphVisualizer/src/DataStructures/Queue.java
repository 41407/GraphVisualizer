/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Simple doublyLinkedList based queue.
 * 
 * @author 41407
 */
public class Queue<E> {
    
    private DoublyLinkedList<E> queue;
    
    public Queue() {
        queue = new DoublyLinkedList();
    }
    
    /**
     * Checks if queue is empty.
     * 
     * @return True if empty, false if not.
     */
    public boolean isEmpty() {
        if(queue.min() == null) {
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
        queue.insertLast(element);
    }

    /**
     * Returns and removes element that was first inserted into queue.
     * 
     * @return Element that was inserted into queue first.
     */
    public E dequeue() {
        final E returnValue = (E) queue.min();
        queue.deleteMin();
        return returnValue;
    }
}
