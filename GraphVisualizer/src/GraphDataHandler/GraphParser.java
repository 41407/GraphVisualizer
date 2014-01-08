/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDataHandler;

import DataStructures.DynamicArray;
import Graph.Graph;
import Graph.Vertex;

/**
 * Parser to transform an adjacency matrix into a Graph object
 *
 * @author 41407
 */
public class GraphParser {

    /**
     * Takes a text input of an adjacency matrix where entries are separated
     * with a whitespace and rows with enter. Any non-integer entry means that
     * there is no edge between those vertices.
     *
     * e.g. 
     *      10 4 9
     *      2 x 3
     *      x 3 x
     *
     * @param matrix String array to be interpreted.
     * @return Graph based on input.
     * 
     */
    public static Graph initialize(DynamicArray<String> matrix) {
        Graph g = new Graph();
        String[][] adjacencyMatrix = parseStringArray(matrix);
        Vertex[] vertices = new Vertex[matrix.getSize()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
            g.addVertex(vertices[i]);
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                if (adjacencyMatrix[i][j].matches("^[0-9]{1,9}$")) {
                    int element = Integer.parseInt(adjacencyMatrix[i][j]);
                    g.addEdge(vertices[i], vertices[j]);
                }
            }
        }
        return g;
    }

    private static String[][] parseStringArray(DynamicArray<String> matrix) {
        String[][] adjacencyMatrix = new String[matrix.getSize()][matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++) {
            String[] parsedString = matrix.get(i).split("\\s+");
            for (int j = 0; j < parsedString.length; j++) {
                adjacencyMatrix[i][j] = parsedString[j];
            }
        }
        return adjacencyMatrix;
    }
}
