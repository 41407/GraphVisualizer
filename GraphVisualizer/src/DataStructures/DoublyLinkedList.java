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
public class DoublyLinkedList {

    private LinkedList<Element> l;

    public DoublyLinkedList() {
        this.l = new LinkedList();
    }

    public void insert(Element e) {
        l.addFirst(e);
    }

    public void delete(Element e) {
        l.remove(e);
    }

    public boolean contains(Element e) {
        if (l.isEmpty()) {
            return false;
        }
        return l.contains(e);
    }

    public Element min() {
        if (l.isEmpty()) {
            return null;
        }
        return l.element();
    }

    public Element max() {
        if (l.isEmpty()) {
            return null;
        }
        return l.peekLast();
    }

    public Element succ(Element e) {
        if (l.isEmpty()) {
            return null;
        }
        int succIndex = l.indexOf(e) + 1;
        if (succIndex < l.size()) {
            return l.get(succIndex);
        }
        return null;
    }

    public Element pred(Element e) {
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
