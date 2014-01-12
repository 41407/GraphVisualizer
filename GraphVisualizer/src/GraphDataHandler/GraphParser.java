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
     * Static variable to tell whether a graph being generated is directed or
     * not. Better be careful!
     */
    static boolean directed;

    /**
     * Takes a text input of an adjacency matrix where entries are separated
     * with a whitespace and rows with enter. Any non-integer entry means that
     * there is no edge between those vertices.
     *
     * e.g.
     * x 1 1
     * 1 x 1
     * 1 1 x
     *
     * Following string array would result in a directed graph:
     *
     * Directed
     * x 1 1
     * 1 x x
     * x 1 x
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
                    int weight = Integer.parseInt(adjacencyMatrix[i][j]);
                    g.addEdge(vertices[i], vertices[j], weight);
                    if (!directed) {
                        g.addEdge(vertices[j], vertices[i], weight);
                    }
                }
            }
        }
        g.setDirected(directed);
        return g;
    }

    /**
     * Takes a string array as an input, and returns an adjacency matrix.
     * @param matrix DynamicArray of strings
     * @return Adjacency matrix
     */
    private static String[][] parseStringArray(DynamicArray<String> matrix) {
        if (matrix.get(0).toLowerCase().equals("directed")) {
            matrix.delete(0);
            directed = true;
        } else {
            directed = false;
        }
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
