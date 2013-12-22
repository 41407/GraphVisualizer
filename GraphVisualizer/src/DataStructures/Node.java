/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 * Simple node to be used as an element in various data strutures.
 * 
 * @author 41407
 */
public class Node implements Comparable<Node> {

    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public Node(int key) {
        this.key = key;
    }

    @Override
    public int compareTo(Node o) {
        return this.key-o.key;
    }
}
