/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDataHandler;

import DataStructures.DynamicArray;
import Graph.Graph;
import Graph.Vertex;
import java.util.Random;

/**
 * Class to create random graphs
 *
 * @author 41407
 */
public class RandomGraph {

    private static Random r = new Random();

    /**
     * A slow and rudimentary random graph generator that throws a dice for
     * each element in adjacency matrix of undirected graph to create an edge
     * with weight of 1.
     *
     * @param size Desired amount of vertices in graph
     * @return Adjacency matrix
     */
    public static DynamicArray<String> generateRandom(int size) {
        DynamicArray<String> array = new DynamicArray();
        for (int i = 0; i < size; i++) {
            String line = "";
            for (int j = 0; j < size; j++) {
                if (j > i) {
                    int random = r.nextInt(100);
                    if (random < 85) {
                        line += "x ";
                    } else {
                        line += 1 + " ";
                    }
                } else {
                    line += "x ";
                }
            }
            array.insert(line);
        }
        return array;
    }

    /**
     * This will generate an arguably smoother randomized graph using the same
     * slow technique as generateRandom().
     *
     * @param size Desired amount of vertices in graph
     * @return Adjacency matrix
     */
    public static DynamicArray<String> generateSmoother(int size) {
        DynamicArray<String> array = new DynamicArray();
        for (int i = 0; i < size; i++) {
            String line = "";
            int l = 0;
            for (int j = 0; j < size; j++) {
                if (j < i + 4) {
                    line += "x ";
                } else if (l < 3) {
                    if (l == 1) {
                        line += "x ";
                    } else {
                        line += r.nextInt(10) + 1 + " ";
                    }
                    l++;
                } else {
                    line += "x ";
                }
            }
            array.insert(line);
        }
        return array;
    }

    /**
     * Quick and dirty graph generator.
     *
     * @param size Desired amount of vertices.
     * @return randomized graph
     */
    public static Graph quick(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(0));
            if (i > 1) {
                g.addEdge(g.getVertices().get(i), g.getVertices().get(i - 1), r.nextInt((10) + 1));
                g.addEdge(g.getVertices().get(i), g.getVertices().get(i - 2), r.nextInt((10) + 1));
            }
        }
        return g;
    }
    /*
     public static Graph quickTotallyRandom(int size, int edgesPerVertex) {
     Graph g = new Graph();
     for (int i = 0; i < size; i++) {
     g.addVertex(new Vertex(0));
     }
     Random r = new Random();
     for (int i = 0; i < size*edgesPerVertex; i++) {
     g.addEdge(g.getVertices().get(r.nextInt(g.getVertices().getSize())), g.getVertices().get(r.nextInt(g.getVertices().getSize())), r.nextInt(10)+1);
     }
     return g;
     }
     */
}
