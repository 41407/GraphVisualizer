/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Visualizer.AlgorithmInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for a UI button
 *
 * @author 41407
 */
public class StepButtonListener implements ActionListener {

    private GraphDrawer d;

    public StepButtonListener(GraphDrawer d) {
        this.d = d;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AlgorithmInterface.getAlgorithm().singleStep();
    }
}