/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Node in DoublyLinkedList
 *
 * @author 41407
 */
public class DoublyLinkedNode {

    private DoublyLinkedNode pred;
    private DoublyLinkedNode succ;
    private Object data;

    public DoublyLinkedNode() {
        this.pred = null;
        this.succ = null;
        this.data = null;
    }

    public DoublyLinkedNode(Object data) {
        this();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
