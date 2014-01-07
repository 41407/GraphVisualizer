/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Simple stack structure
 * 
 * @author 41407
 */
public class Stack<E> {

    private DynamicArray<E> stack;

    public Stack() {
        this.stack = new DynamicArray();
    }

    /**
     * Inserts parameter object in stack
     * 
     * @param element Object to be inserted
     */
    public void push(E element) {
        stack.insert(element);
    }

    /**
     * Returns the last object that was inserted in stack
     * 
     * @return last object that was inserted in stack
     */
    public E pop() {
        final E returnValue = (E) stack.get(stack.getSize()-1);
        stack.delete(stack.getSize()-1);
        return returnValue;
    }

    /**
     * Checks whether stack is empty or not
     * 
     * @return Returns true if stack is empty, false if not
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}