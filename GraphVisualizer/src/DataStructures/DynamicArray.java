/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Array that doubles its size whenever it gets full. Starts off with size of
 * 10.
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
     * @param element Object to be inserted
     */
    public void insert(E element) {
        if (size == array.length) {
            Object[] doubledArray = new Object[size * 2];
            for (int i = 0; i < array.length; i++) {
                doubledArray[i] = array[i];
            }
            this.array = doubledArray;
        }
        array[size] = element;
        size++;
    }

    /**
     * Returns true if array contains parameter element
     *
     * @param element element to be searched for
     * @return true if element is contained within array, false if not
     */
    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if (array[i].equals(element)) {
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
        if (index < size) {
            for (int i = index + 1; i < size; i++) {
                array[i - 1] = array[i];
            }
            size--;
        }
    }

    /**
     * Removes element from list and shifts remaining elements left.
     *
     * @param element element to be deleted
     */
    public void delete(E element) {
        int indexOfElement = indexOf(element);
        this.delete(indexOfElement);
    }

    /**
     * Returns the index of element e.
     *
     * @param element Element to be searched for
     * @return Index of element, or this.size if element not found
     */
    private int indexOf(E element) {
        for (int indexOfElement = 0; indexOfElement < size; indexOfElement++) {
            if (array[indexOfElement].equals(element)) {
                return indexOfElement;
            }
        }
        return size;
    }

    /**
     * Replace element at index with another element.
     *
     * @param index index of element to be replaced. If specified index is less
     * than zero or greater than size of the array, this method does nothing.
     * @param element replacing element
     */
    public void set(int index, E element) {
        if (index >= 0) {
            if (index < size) {
                array[index] = element;
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
            final E returnValue = (E) array[index];
            return returnValue;
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

    /**
     * Returns a boolean depending on if array is empty or not
     *
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return (size == 0);
    }
}