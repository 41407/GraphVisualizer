/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Node element of DoublyLinkedList
 *
 * @author 41407
 */
public class DoublyLinkedNode {

    /**
     * Node previous to this node: one closer to head
     */
    private DoublyLinkedNode pred;
    /**
     * Node next to this node: one closer to tail
     */
    private DoublyLinkedNode succ;
    /**
     * Object contained within this node
     */
    private Object key;

    public DoublyLinkedNode() {
        this.pred = null;
        this.succ = null;
        this.key = null;
    }

    public DoublyLinkedNode(Object key) {
        this();
        this.key = key;
    }

    public DoublyLinkedNode getPred() {
        return pred;
    }

    public void setPred(DoublyLinkedNode pred) {
        this.pred = pred;
    }

    public DoublyLinkedNode getSucc() {
        return succ;
    }

    public void setSucc(DoublyLinkedNode succ) {
        this.succ = succ;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }
}
