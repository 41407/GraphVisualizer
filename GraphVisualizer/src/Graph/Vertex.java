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

    private int distance;
    private int id;
    private int x;
    private int y;

    public Vertex(int id) {
        this.id = id;
    }

    public Vertex(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getKey() {
        return distance;
    }

    @Override
    public int compareTo(Element o) {
        return this.distance - o.getKey();
    }
}