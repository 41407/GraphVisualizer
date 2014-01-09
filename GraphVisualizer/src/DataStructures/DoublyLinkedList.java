/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Simple doubly linked list. Knows its head and tail. In addition to methods
 * included in tira.pdf, this one has deleteMin() and insertLast() to facilitate
 * implementation of queues and stacks.
 *
 * @author 41407
 */
public class DoublyLinkedList<E> {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Inserts parameter element as the first (head) element of the list.
     *
     * @param e Element to be inserted
     */
    public void insert(E e) {
        DoublyLinkedNode n = new DoublyLinkedNode();
        n.setKey(e);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            if (head != null) {
                head.setPred(n);
                n.setSucc(head);
                head = n;
            }
        }
        size++;
    }

    /**
     * Inserts parameter element as the last (tail) element of the list.
     *
     * @param e Element to be inserted
     */
    public void insertLast(E e) {
        DoublyLinkedNode n = new DoublyLinkedNode();
        n.setKey(e);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            if (tail != null) {
                tail.setSucc(n);
                n.setPred(tail);
                tail = n;
            }
        }
        size++;
    }

    /**
     * Finds parameter entry and deletes it.
     *
     * @param e Entry to be deleted
     */
    public void delete(E e) {
        DoublyLinkedNode delNode = this.search(e);
        if (delNode != null) {
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
            size--;
        }
    }

    /**
     * Check if list contains parameter object
     *
     * @param e object to be searched for
     * @return True if object is found within list, false if not
     */
    public boolean contains(E e) {
        if (search(e) != null) {
            return true;
        }
        return false;
    }

    /**
     * Deletes first entry of list.
     */
    void deleteMin() {
        if (head != null) {
            if (head.equals(tail)) {
                head = null;
                tail = null;
            } else {
                if (head.getSucc() != null) {
                    head.getSucc().setPred(null);
                }
                head = head.getSucc();
            }
            size--;
        }
    }

    /**
     * Returns the first (head) element of the list.
     *
     * @return head if list is not empty, null if empty
     */
    public E min() {
        if (tail != null) {
            final E e = (E) head.getKey();
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
            final E returnValue = (E) tail.getKey();
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
                final E returnValue = (E) node.getSucc().getKey();
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
                final E returnValue = (E) node.getPred().getKey();
                return returnValue;
            }
        }
        return null;
    }

    /**
     * Returns the node that contains the parameter element
     *
     * @param e element node of which is to be searched
     * @return corresponding node, or null if not found
     */
    private DoublyLinkedNode search(E e) {
        DoublyLinkedNode n = head;
        while (n != null) {
            if (n.getKey().equals(e)) {
                return n;
            }
            n = n.getSucc();
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
