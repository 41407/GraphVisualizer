/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 * Takes a text input of an adjacency matrix where entries are separated with
 * a whitespace and rows with enter.
 * 
 * e.g.
 *          10  4   9
 *          2   0   3
 *          0   3   0
 * 
 * Returns a new Graph based on input.
 * 
 * For now, we'll interpret weight of 0 as no edge between vertices.
 * 
 * @author 41407
 */
public class GraphParser {
    
    public static Graph initialize(String[] matrix) {
        Graph g = new Graph();
        int[][] adjacencyMatrix = parseStringArray(matrix);
        Vertex[] vertices = new Vertex[matrix.length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
            g.addVertex(vertices[i]);
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                if(adjacencyMatrix[i][j] != 0) {
                    Edge e = new Edge(vertices[i], vertices[j]);
                    g.addEdge(e);
                }
            }
        }
        return g;
    }

    private static int[][] parseStringArray(String[] matrix) {
        int[][] adjacencyMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            String[] parsedString = matrix[i].split("\\s+");
            for (int j = 0; j < parsedString.length; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(parsedString[j]);
            }
        }
        return adjacencyMatrix;
    }
}
