/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.Element;

/**
 * Vertex in graph.
 *
 * Implements Element, so it can be used as an element in data structures.
 *
 * @author 41407
 */
public class Vertex implements Element, Comparable<Element> {

    private int key;

    public Vertex(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public int compareTo(Element o) {
        return this.key - o.getKey();
    }
}
