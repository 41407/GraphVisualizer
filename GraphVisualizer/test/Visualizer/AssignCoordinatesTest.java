/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizer;

import Graph.Graph;
import GraphDataHandler.GraphParser;
import Graph.Vertex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 41407
 */
public class AssignCoordinatesTest {

    public AssignCoordinatesTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void assignCoordinatesAssignsCoordinates() {
        String[] s = {"0 0 0 0",
                      "0 0 0 0",
                      "0 0 0 0",
                      "0 0 0 0"};
        Graph g = GraphParser.initialize(s);
        AssignCoordinates.initialize(g);
        Vertex v;
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            v = (Vertex) g.getVertices().get(i);
            System.out.println("v" + i + ": " + v.getX() + ", " + v.getY());
        }
    }
}