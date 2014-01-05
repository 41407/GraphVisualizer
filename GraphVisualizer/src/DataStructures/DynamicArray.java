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

    private Object[] array;
    private int size;

    public DynamicArray() {
        this.array = new Object[10];
        this.size = 0;
    }

    /**
     * Inserts parameter object after the last entry in list.
     *
     * @param e Object to be inserted
     */
    public void insert(E e) {
        array[size] = e;
        size++;
    }

    /**
     * Returns true if array contains parameter element
     *
     * @param e element to be checked
     * @return true if element is contained within array, false if not
     */
    public boolean contains(E e) {
        for (int i = 0; i < this.size; i++) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes element from list by index and shifts remaining elements left.
     *
     * @param index index to delete from
     */
    public void delete(int index) {
        if(index < size) {
            for (int i = index+1; i < size; i++) {
                array[i-1] = array[i];
            }
            size--;
        }
    }
    
    /**
     * Removes element from list and shifts remaining elements left.
     *
     * @param e element to be deleted
     */
    public void delete(E e) {
        int index = indexOf(e);
        this.delete(index);
    }
   
    /**
     * Returns the index of element e.
     * 
     * @param e Element to be found
     * @return Index of element, or this.size if element not found
     */
    private int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return size;
    }

    /**
     * Replace element at index with another element.
     *
     * @param index index of element to be replaced
     * @param e replacing element
     */
    public void set(int index, E e) {
        if (index >= 0) {
            if (index < size) {
                array[index] = e;
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
            final E e = (E) array[index];
            return e;
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