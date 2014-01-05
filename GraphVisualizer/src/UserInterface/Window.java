/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Graph.Graph;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Main program window
 * 
 * @author 41407
 */
public class Window implements Runnable {
    
    private JFrame frame;
    private GraphCanvas canvas;
    
    public Window(GraphCanvas canvas) {
        this.canvas = canvas;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Graph Visualizer");
        frame.setPreferredSize(new Dimension(800, 600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        initializeComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeComponents(Container contentPane) {
        JButton button = new JButton("Stop the annoying rectangle and draw a graph");
        button.addActionListener(new ButtonListener(canvas.getDrawer()));
        contentPane.add(canvas);
        contentPane.add(button, BorderLayout.SOUTH);
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
