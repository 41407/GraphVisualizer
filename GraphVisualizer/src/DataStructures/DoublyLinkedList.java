/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Simple doubly linked list
 *
 * @author 41407
 */
public class DoublyLinkedList<E> {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts parameter element as the first (head) element of the list.
     *
     * @param e Element to be inserted
     */
    public void insert(E e) {
        DoublyLinkedNode n = new DoublyLinkedNode();
        n.setData(e);
        n.setSucc(head);
        n.setPred(null);
        if (head != null) {
            head.setPred(n);
        }
        head = n;
        if (tail == null) {
            tail = n;
        }
    }

    /**
     * Inserts parameter element as the last (tail) element of the list.
     *
     * @param e Element to be inserted
     */
    public void insertLast(E e) {
        if (head == null) {
            this.insert(e);
        } else {
            DoublyLinkedNode n = new DoublyLinkedNode();
            n.setData(e);
            n.setSucc(null);
            n.setPred(tail);
            if (tail != null) {
                tail.setSucc(n);
            }
            tail = n;
        }
    }

    public void delete(E e) {
        DoublyLinkedNode delNode = this.search(e);
        DoublyLinkedNode succNode = delNode.getSucc();
        DoublyLinkedNode predNode = delNode.getPred();
        if (succNode != null) {
            succNode.setPred(predNode);
        } else {
            tail = predNode;
            predNode.setSucc(null);
        }
        if (predNode != null) {
            predNode.setSucc(succNode);
        } else {
            head = succNode;
            succNode.setPred(null);
        }
    }

    public boolean contains(E e) {
        if (search(e) != null) {
            return true;
        }
        return false;
    }

    /**
     * Returns the first (head) element of the list.
     *
     * @return head if list is not empty, null if empty
     */
    public E min() {
        if (tail != null) {
            final E e = (E) head.getData();
            return e;
        } else {
            return null;
        }
    }

    /**
     * Returns the last (tail) element of the list.
     *
     * @return tail if list is not empty, null if empty
     */
    public E max() {
        if (tail != null) {
            final E returnValue = (E) tail.getData();
            return returnValue;
        } else {
            return null;
        }
    }

    /**
     * Returns the element that succeeds the parameter element in the list.
     *
     * @param e Element of whose successor is to be returned
     * @return Successor to parameter element, or one closer to the tail. If
     * parameter element does not exist, returns null.
     */
    public E succ(E e) {
        DoublyLinkedNode node = search(e);
        if (node != null) {
            if (node.getSucc() != null) {
                final E returnValue = (E) node.getSucc().getData();
                return returnValue;
            }
        }
        return null;
    }

    /**
     * Returns the element that precedes the parameter element in the list.
     *
     * @param e Element of whose precedent is to be returned
     * @return Precedent to parameter element, or one closer to the head
     */
    public E pred(E e) {
        DoublyLinkedNode node = search(e);
        if (node != null) {
            if (node.getPred() != null) {
                final E returnValue = (E) node.getPred().getData();
                return returnValue;
            }
        }
        return null;
    }

    private DoublyLinkedNode search(E e) {
        DoublyLinkedNode n = head;
        while (n != null) {
            if (n.getData().equals(e)) {
                return n;
            }
            n = n.getSucc();
        }
        return null;
    }
}
