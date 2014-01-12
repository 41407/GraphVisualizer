/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Node element of DoublyLinkedList. Knows its preceding and succeeding
 * neighbours.
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

    /**
     * This constructor initializes all fields as null.
     */
    public DoublyLinkedNode() {
        this.pred = null;
        this.succ = null;
        this.key = null;
    }

    /**
     *
     * This constructor initializes all fields except key (contained object) as
     * null.
     *
     * @param key Object to be contained within node
     */
    public DoublyLinkedNode(Object key) {
        this();
        this.key = key;
    }

    /**
     *
     * @return Returns the node previous to this one, closer to head
     */
    public DoublyLinkedNode getPred() {
        return pred;
    }

    /**
     * Assigns parameter node as predecessor to this one, ie as one closer to
     * head
     *
     * @param pred Node to be set as predecessor
     */
    public void setPred(DoublyLinkedNode pred) {
        this.pred = pred;
    }

    /**
     *
     * @return Returns the node next to this one, closer to tail
     */
    public DoublyLinkedNode getSucc() {
        return succ;
    }

    /**
     * Assigns parameter node as successor to this one, ie as one closer to tail
     *
     * @param succ Node to be set as successor
     */
    public void setSucc(DoublyLinkedNode succ) {
        this.succ = succ;
    }

    /**
     * 
     * @return Object contained within node
     */
    public Object getKey() {
        return key;
    }

    /**
     * 
     * @param key Content to be stored within node
     */
    public void setKey(Object key) {
        this.key = key;
    }
}
