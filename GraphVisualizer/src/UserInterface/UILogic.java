/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.SwingUtilities;

/**
 *
 * @author 41407
 */
public class UILogic {
    public static void start() {
        GraphDrawer drawer = new GraphDrawer();
        GraphCanvas canvas = new GraphCanvas(drawer);
        Window w = new Window(canvas);
        SwingUtilities.invokeLater(w);
    }
}
