/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Visualizer.AssignCoordinates;
import Visualizer.GraphInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens to action events of redraw button.
 *
 * @author 41407
 */
class RedrawButtonListener implements ActionListener {

    private GraphDrawer d;

    public RedrawButtonListener(GraphDrawer d) {
        this.d = d;
    }

    /**
     * Redraws the graph stored in GraphInterface when button is clicked.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AssignCoordinates.initialize(GraphInterface.getGraph());
    }
}
