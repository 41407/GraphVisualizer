/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.LinkedList;

/**
 * Simple doubly linked list
 *
 * @author 41407
 */
public class DoublyLinkedList<E> {

    private LinkedList<E> l;

    public DoublyLinkedList() {
        this.l = new LinkedList();
    }

    /**
     * Inserts parameter element as the first (head) element of the list.
     *
     * @param e Element to be inserted
     */
    public void insert(E e) {
        l.addFirst(e);
    }

    /**
     * Inserts parameter element as the last (tail) element of the list.
     *
     * @param e Element to be inserted
     */
    public void insertLast(E e) {
        l.addLast(e);
    }

    public void delete(E e) {
        l.remove(e);
    }

    public boolean contains(E e) {
        if (l.isEmpty()) {
            return false;
        }
        return l.contains(e);
    }

    /**
     * Returns the first (head) element of the list.
     *
     * @return
     */
    public E min() {
        if (l.isEmpty()) {
            return null;
        }
        return l.element();
    }

    /**
     * Returns the last (tail) element of the list.
     *
     * @return
     */
    public E max() {
        if (l.isEmpty()) {
            return null;
        }
        return l.peekLast();
    }

    /**
     * Returns the element that succeeds the parameter element in the list.
     *
     * @param e Element of whose successor is to be returned
     * @return Successor to parameter element
     */
    public E succ(E e) {
        if (l.isEmpty()) {
            return null;
        }
        int succIndex = l.indexOf(e) + 1;
        if (succIndex < l.size()) {
            return l.get(succIndex);
        }
        return null;
    }

    /**
     * Returns the element that precedes the parameter element in the list.
     *
     * @param e Element of whose precedent is to be returned
     * @return Precedent to parameter element
     */
    public E pred(E e) {
        if (l.isEmpty()) {
            return null;
        }
        int predIndex = l.indexOf(e) - 1;
        if (predIndex >= 0) {
            return l.get(predIndex);
        }
        return null;
    }
}
