/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import DataStructures.Element;

/**
 * Edge between two vertices. Can be weighted and/or directional
 *
 * Implements Element, so it can be used as an element in data structures.
 *
 * @author 41407
 */
public class Edge implements Element, Comparable<Element> {

    private int weight;
    private Vertex start;
    private Vertex end;
    private boolean directional;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public boolean isDirectional() {
        return directional;
    }

    public void setDirectional(boolean directional) {
        this.directional = directional;
    }

    @Override
    public int getKey() {
        return weight;
    }

    @Override
    public int compareTo(Element o) {
        return this.weight - o.getKey();
    }

    void flip() {
        Vertex temporary = this.start;
        this.start = end;
        this.end = temporary;
    }
}
