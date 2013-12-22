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
public class DynamicArray {

    private ArrayList<Element> l;
    private int size;

    public DynamicArray() {
        this.l = new ArrayList();
        this.size = 0;
    }

    public void insert(Element e) {
        l.add(e);
        size++;
    }

    /**
     * Contrary to ArrayList of Java, sets the element at index to null and does
     * not shift remaining elements to the left.
     *
     * @param index of element to be removed
     */
    public void delete(int index) {
        if (index >= 0) {
            if (index < size) {
                l.set(index, null);
            }
        }
    }

    /**
     * Not quite sure how to react to index out of bounds yet. Should the list
     * just be resized to allow new value to be inserted?
     *
     * @param index
     * @param e
     */
    public void set(int index, Element e) {
        if (index >= 0) {
            if (index < size) {
                l.set(index, e);
            }
        }
    }

    public Element get(int index) {
        if (index >= 0) {
            if (index < size) {
                return l.get(index);
            }
        }
        return null;
    }
}
