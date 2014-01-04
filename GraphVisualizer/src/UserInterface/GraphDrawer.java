/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Graph.Graph;
import java.awt.Graphics;

/**
 *
 * @author 41407
 */
public class GraphDrawer {

    private Graph graph;

    public void draw(Graphics graphics) {
        graphics.fillRect((int)(System.currentTimeMillis()%200), 10, 200, 200);
    }

    public void setGraph(Graph g) {
        this.graph = g;
    }
}
