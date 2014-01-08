/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import DataStructures.DynamicArray;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Logic for drawing a graph
 *
 * @author 41407
 */
public class GraphDrawer {

    private Graph graph;

    public void draw(Graphics graphics) {
        /**
         * A simple test to see if I succeeded in making a self refreshing
         * drawing surface :)
         */
        if (graph == null) {
            graphics.fillRect((int) (System.currentTimeMillis() % 1000) - 200, 10,
                    200, 200);
        } else {
            DynamicArray<Vertex> vertices = graph.getVertices();
            DynamicArray<Edge> edges = graph.getEdges();
            for (int i = 0; i < vertices.getSize(); i++) {
                drawVertex(graphics, vertices.get(i));
            }
            DynamicArray<Edge> drawnEdges = new DynamicArray();
            for (int i = 0; i < edges.getSize(); i++) {
                if (!drawnEdges.contains(edges.get(i)) && !drawnEdges.contains(Edge.reverse(edges.get(i)))) {
                    drawEdge(graphics, edges.get(i));
                    drawnEdges.insert(edges.get(i));
                }
            }
        }
    }

    public void setGraph(Graph g) {
        this.graph = g;
    }

    /**
     * Draws parameter vertex on canvas
     *
     * @param g
     * @param v Vertex to be drawn
     */
    private void drawVertex(Graphics g, Vertex v) {
        int distance = v.getDistance();
        String distanceString = "";
        if (distance >= Integer.MAX_VALUE - 100000) {
            distanceString = "∞";
        } else {
            distanceString = "" + distance;
        }
        g.fillOval(v.getX(), v.getY(), 20, 20);
        g.drawString(distanceString, v.getX(), v.getY());
    }

    /**
     * Draws parameter edge on canvas
     *
     * @param g
     * @param e Edge to be drawn
     */
    private void drawEdge(Graphics g, Edge e) {
        String weight = "";
        weight += e.getWeight();
        int x1 = e.getStart().getX();
        int y1 = e.getStart().getY();
        int x2 = e.getEnd().getX();
        int y2 = e.getEnd().getY();
        g.drawLine(x1 + 10, y1 + 10, x2 + 10, y2 + 10);
        g.setFont(new Font("Sans", 1, 10));
        g.drawString(weight, (x1 + x2) / 2, (y1 + y2) / 2);

    }
}
