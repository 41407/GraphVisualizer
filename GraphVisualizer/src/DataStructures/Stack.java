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
     * @param e Object to be inserted
     */
    public void push(E e) {
        stack.insert(e);
    }

    /**
     * Returns the last object that was inserted in stack
     * 
     * @return last object that was inserted in stack
     */
    public E pop() {
        final E e = (E) stack.get(stack.getSize()-1);
        stack.delete(stack.getSize()-1);
        return e;
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
