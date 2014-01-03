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

    public void insert(E e) {
        l.addFirst(e);
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

    public E min() {
        if (l.isEmpty()) {
            return null;
        }
        return l.element();
    }

    public E max() {
        if (l.isEmpty()) {
            return null;
        }
        return l.peekLast();
    }

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
