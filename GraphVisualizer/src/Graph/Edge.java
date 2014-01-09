/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 * Edge between two vertices. Can be weighted and/or directional
 *
 * Implements Element, so it can be used as an element in data structures.
 *
 * @author 41407
 */
public class Edge implements Comparable<Edge> {

    private int weight;
    private Vertex start;
    private Vertex end;
    private boolean visited;
    private boolean directed = false;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    public Edge(Vertex start, Vertex end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Edge(Vertex start, Vertex end, int weight, boolean directed) {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.directed = true;
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

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.getWeight();
    }

    public boolean equals(Edge o) {
        if (o.start == this.start && o.end == this.end) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this edge is a reversed version of parameter edge
     *
     * @param o Edge to be checked against
     * @return true if edges are reversed versions of each other, false if not
     */
    public boolean isReverseOf(Edge o) {
        if (o.start == this.end && o.end == this.start) {
            return true;
        }
        return false;
    }

    /**
     * Returns a reversed version of parameter edge without modifying original
     * edge.
     *
     * @param edge Edge, reverse of which will be returned
     * @return Reverse of parameter edge
     */
    public static Edge reverse(Edge edge) {
        return new Edge(edge.end, edge.start, edge.weight);
    }

    /**
     * Reverses the direction of the edge. Works with non-directional edges as
     * well.
     */
    void flip() {
        Vertex temporary = this.start;
        this.start = end;
        this.end = temporary;
    }

    public void setVisited(boolean b) {
        this.visited = b;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
