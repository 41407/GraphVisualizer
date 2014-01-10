/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDataHandler;

import DataStructures.DynamicArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to load adjacency matrix from file
 *
 * @author 41407
 */
public class FileLoader {

    /**
     * File in question
     */
    private static File graphFile;
    /**
     * Scanner used to read file
     */
    private static Scanner scanner;
    /**
     * Lines contained within file
     */
    private static DynamicArray<String> lines;

    /**
     * Loads a graph in form of a dynamicArray of Strings out of a file
     *
     * @param path file to load the graph from
     * @return DynamicAray of Strings
     */
    public static DynamicArray<String> loadFile(String path) throws FileNotFoundException {
   //     String filePath = FileLoader.class.getResource(path).getPath();
        String filePath = System.getProperty("user.dir");
        filePath += "/" + path;
 //       System.out.println(filePath);
        graphFile = new File(filePath);
        scanner = new Scanner(graphFile);
        lines = new DynamicArray();
        readFile();
        return lines;
    }

    /**
     * Reads lines from file
     */
    private static void readFile() {
        while (scanner.hasNext()) {
            lines.insert(scanner.nextLine());
        }
    }
}
