/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Graph.Graph;
import Visualizer.GraphLoader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for a UI button
 *
 * @author 41407
 */
public class ButtonListener implements ActionListener {

    private GraphDrawer d;

    public ButtonListener(GraphDrawer d) {
        this.d = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        d.setGraph(GraphLoader.getGraph());
    }
}