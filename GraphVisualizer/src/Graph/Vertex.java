/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Algorithms.VertexColor;

/**
 * Vertex in graph.
 *
 * @author 41407
 */
public class Vertex implements Comparable<Vertex> {
    
    private int distance;
    private int id;
    private int x;
    private int y;
    private VertexColor color;
    private Vertex path;
    
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

    public int getId() {
        return id;
    }

    /**
     * Sets the x and y coordinates of the vertex
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
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
    public int compareTo(Vertex o) {
        return this.distance - o.getDistance();
    }

    public VertexColor getColor() {
        return color;
    }

    public void setColor(VertexColor color) {
        this.color = color;
    }

    public Vertex getPath() {
        return path;
    }

    public void setPath(Vertex path) {
        this.path = path;
    }
}