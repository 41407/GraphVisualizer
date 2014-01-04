/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 41407
 */
public class GraphCanvas extends JPanel {
    private GraphDrawer drawer;

    public GraphCanvas(GraphDrawer drawer) {
        super.setBackground(Color.WHITE);
        this.drawer = drawer;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawer.draw(graphics);
        this.repaint();
    }
}
