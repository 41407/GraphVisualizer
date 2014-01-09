/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Visualizer.AlgorithmInterface;
import Visualizer.AssignCoordinates;
import Visualizer.GraphInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 41407
 */
class RedrawButtonListener implements ActionListener {

    private GraphDrawer d;

    public RedrawButtonListener(GraphDrawer d) {
        this.d = d;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AssignCoordinates.initialize(GraphInterface.getGraph());
    }
}
