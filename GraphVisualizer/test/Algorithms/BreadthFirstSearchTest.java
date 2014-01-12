/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Graph.Graph;
import GraphDataHandler.FileLoader;
import GraphDataHandler.GraphParser;
import java.io.FileNotFoundException;
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
public class BreadthFirstSearchTest {

    private Graph g;
    private BreadthFirstSearch b;
    private VertexColor[] expected;
    private VertexColor[] actual;

    public BreadthFirstSearchTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        expected = new VertexColor[4];
        actual = new VertexColor[4];
        try {
            g = GraphParser.initialize(FileLoader.loadFile("testGraph"));
            b = new BreadthFirstSearch(g);
        } catch (FileNotFoundException e) {
            fail("FileLoader failed");
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorDoesNotColor() {
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            expected[i] = null;
        }
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            actual[i] = g.getVertices().get(i).getColor();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInitializeColorsFirstVertexGrayOthersWhite() {
        b.initialize(g.getVertices().get(0));
        expected[0] = VertexColor.GRAY;
        for (int i = 1; i < g.getVertices().getSize(); i++) {
            expected[i] = VertexColor.WHITE;
        }
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            actual[i] = g.getVertices().get(i).getColor();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void stepOneCorrectColors() {
        b.initialize(g.getVertices().get(0));
        b.singleStep();
        expected[0] = VertexColor.BLACK;
        expected[1] = VertexColor.GRAY;
        for (int i = 2; i < g.getVertices().getSize(); i++) {
            expected[i] = VertexColor.WHITE;
        }
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            actual[i] = g.getVertices().get(i).getColor();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void stepTwoCorrectColors() {
        b.initialize(g.getVertices().get(0));
        b.singleStep();
        b.singleStep();
        expected[0] = VertexColor.BLACK;
        expected[1] = VertexColor.BLACK;
        expected[2] = VertexColor.GRAY;
        for (int i = 3; i < g.getVertices().getSize(); i++) {
            expected[i] = VertexColor.WHITE;
        }
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            actual[i] = g.getVertices().get(i).getColor();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void stepThreeCorrectColors() {
        b.initialize(g.getVertices().get(0));
        b.singleStep();
        b.singleStep();
        b.singleStep();
        expected[0] = VertexColor.BLACK;
        expected[1] = VertexColor.BLACK;
        expected[2] = VertexColor.BLACK;
        expected[3] = VertexColor.GRAY;
        for (int i = 0; i < g.getVertices().getSize(); i++) {
            actual[i] = g.getVertices().get(i).getColor();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void finalStepCorrectColors() {
        b.initialize(g.getVertices().get(0));
        for (int i = 0; i < 4; i++) {
            b.singleStep();
            expected[i] = VertexColor.BLACK;
            actual[i] = g.getVertices().get(i).getColor();
        }
        assertArrayEquals(expected, actual);
    }
}