/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphDataHandler;

import DataStructures.DynamicArray;
import java.util.Random;

/**
 *
 * @author 41407
 */
public class RandomGraph {

    private static Random r = new Random();

    public static DynamicArray<String> generate(int size) {
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
}
