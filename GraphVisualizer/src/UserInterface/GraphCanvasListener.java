/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Graph.Vertex;
import Visualizer.AlgorithmInterface;
import Visualizer.GraphInterface;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 * Listens to mouse input events on graph canvas
 *
 * @author 41407
 */
class GraphCanvasListener implements MouseInputListener {

    private GraphDrawer drawer;

    public GraphCanvasListener() {
    }

    public GraphCanvasListener(GraphDrawer drawer) {
        this.drawer = drawer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Vertex v = FindNearestVertex.at(GraphInterface.getGraph(), x, y);
        AlgorithmInterface.startDijkstra(v);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}