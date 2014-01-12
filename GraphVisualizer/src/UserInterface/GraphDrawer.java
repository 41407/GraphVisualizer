/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Algorithms.VertexColor;
import DataStructures.DynamicArray;
import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Logic for drawing a graph
 *
 * @author 41407
 */
public class GraphDrawer {

    private Graph graph;

    public void draw(Graphics graphics) {
        DynamicArray<Edge> drawnEdges = new DynamicArray();
        DynamicArray<Edge> edges = graph.getEdges();
        for (int i = 0; i < edges.getSize(); i++) {
            if (!drawnEdges.contains(edges.get(i)) || !drawnEdges.contains(Edge.reverse(edges.get(i)))) {
                drawEdge(graphics, edges.get(i));
                drawnEdges.insert(edges.get(i));
            }
        }
        DynamicArray<Vertex> vertices = graph.getVertices();
        for (int i = 0; i < vertices.getSize(); i++) {
            drawVertex(graphics, vertices.get(i));
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
        if (v.getColor() == VertexColor.BLACK) {
            g.setColor(Color.BLACK);
        } else if (v.getColor() == VertexColor.GRAY) {
            g.setColor(Color.YELLOW);
        } else if (v.getColor() == VertexColor.WHITE) {
            g.setColor(Color.red);
        }
        int distance = v.getDistance();

        String distanceString;
        if (distance >= Integer.MAX_VALUE - 100000) {
            distanceString = "∞";
        } else {
            distanceString = "" + distance;
        }
        g.fillOval(v.getX() - 10, v.getY() - 10, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(v.getX() - 10, v.getY() - 10, 20, 20);
        g.setFont(new Font("Sans", 1, 16));
        g.drawString(distanceString, v.getX(), v.getY() - 20);
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
        g.setColor(Color.LIGHT_GRAY);
        if (e.getStart() != e.getEnd()) {
            /**
             * Edge between u and v where u != v
             */
            g.drawLine(x1, y1, x2, y2);
        } else {
            /**
             * Edge between u and u itself
             */
            g.drawOval(x1 - 4, y1 - 4, 30, 30);
        }
        if (e.isVisited()) {
            drawVisitedEdge(g, e);
        }
        if (e.isDirected() && e.getStart() != e.getEnd()) {
            drawArrowhead(g, e);
        }
        g.setFont(new Font("Sans", 1, 10));
        int yModifier = 10;
        int xModifier = -10;
        if ((x1 > x2 && y1 > y2) || (x1 < x2 && y1 < y2)) {
            yModifier = -10;
            xModifier = 10;
        }
        g.setColor(Color.BLACK);
        g.drawString(weight, ((x1 + 20 + x2 + 20)) / 2 + xModifier, ((y1 + 20 + y2 + 20)) / 2);


    }

    /**
     * Draws a thicker black line to indicate that edge has been used
     *
     * @param g Graphics object whose draw methods are used
     * @param e Edge to be drawn
     */
    private void drawVisitedEdge(Graphics g, Edge e) {
        int x1 = e.getStart().getX();
        int y1 = e.getStart().getY();
        int x2 = e.getEnd().getX();
        int y2 = e.getEnd().getY();
        g.setColor(Color.BLACK);

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                g.drawLine(x1 + i, y1 + j, x2 + i, y2 + j);
            }
        }
    }

    /**
     * Draws the arrowhead that points in the direction of parameter directed
     * edge
     *
     * @param g Graphics object whose draw methods are used
     * @param e Edge whose arrowhead to draw
     */
    private void drawArrowhead(Graphics g, Edge e) {
        int x = e.getEnd().getX();
        int y = e.getEnd().getY();
        int startX = e.getStart().getX();
        int startY = e.getStart().getY();
        /**
         * Calculate delta between start and end x and y
         */
        double deltaX = x - startX;
        double deltaY = y - startY;
        /**
         * Calculate length of the edge
         */
        double edgeLength = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        double angle = Math.atan2(deltaY, deltaX) + Math.PI;

        /*
         * Angle between edge and arrow's sides in radians
         */
        double sharpness = 0.45;
        /**
         * first calculate unit vector
         */
        double arrowSize = Math.sqrt(Math.pow((deltaX / edgeLength), 2) + Math.pow((deltaY / edgeLength), 2));
        /**
         * Desired length of side of the arrowhead, in pixels
         */
        arrowSize *= 25;

        Polygon p = new Polygon();
        p.addPoint(x, y);
        p.addPoint((int) (x + arrowSize * Math.cos(angle - sharpness)),
                (int) (y + arrowSize * Math.sin(angle - sharpness)));
        p.addPoint((int) (x + arrowSize * Math.cos(angle + sharpness)),
                (int) (y + arrowSize * Math.sin(angle + sharpness)));
        g.fillPolygon(p);

    }
}
