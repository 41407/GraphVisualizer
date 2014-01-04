/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;

/**
 * Array that aspires to dynamically adjust its size when necessary. Starts off
 * with size of 10, doubling its size whenever it gets full.
 *
 * @author 41407
 */
public class DynamicArray<E> {

    private ArrayList<E> l;
    private int size;

    public DynamicArray() {
        this.l = new ArrayList(10);
        this.size = 0;
    }

    /**
     * Inserts parameter object after the last entry in list.
     *
     * @param e Object to be inserted
     */
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
     * Removes element from list by index and shifts remaining elements left.
     *
     * @param index index to delete from
     */
    public void delete(int index) {
        if (size > index && index >= 0) {
            l.remove(index);
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

    /**
     *
     * @param index index of the object to be returned
     * @return object at specified index
     */
    public E get(int index) {
        if (index >= 0 && index < size) {
            return l.get(index);
        }
        return null;
    }

    /**
     * Returns the current number of elements in list.
     * 
     * @return 
     */
    public int getSize() {
        return size;
    }
}