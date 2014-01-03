/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;

/**
 * Array that aspires to dynamically adjust its size when necessary.
 *
 * @author 41407
 */
public class DynamicArray<E> {

    private ArrayList<E> l;
    private int size;

    public DynamicArray() {
        this.l = new ArrayList();
        this.size = 0;
    }

    public void insert(E e) {
        l.add(e);
        size++;
    }

    /**
     * Returns true if array contains parameter element
     *
     * @param e element to be checked
     * @return true if element is contained within array, false if not
     */
    public boolean contains(E e) {
        return l.contains(e);
    }

    /**
     * Removes element from list and shifts remaining elements left.
     *
     * @param e element to be deleted
     */
    public void delete(E e) {
        if (l.contains(e)) {
            l.remove(e);
            size--;
        }
    }

    /**
     * Replace element at index with another element.
     *
     * Not quite sure how to react to index out of bounds yet. Should the list
     * just be resized to allow new value to be inserted?
     *
     * @param index index of element to be replaced
     * @param e replacing element
     */
    public void set(int index, E e) {
        if (index >= 0) {
            if (index < size) {
                l.set(index, e);
            }
        }
    }

    public E get(int index) {
        if (index >= 0) {
            if (index < size) {
                return l.get(index);
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}