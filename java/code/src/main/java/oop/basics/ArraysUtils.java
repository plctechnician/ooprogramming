package oop.basics;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * Demonstration of:
 * 1. java.util.Arrays class
 * 2. System.arraycopy() method
 */
public class ArraysUtils {
    // this is a comment
    public static void main(String[] main) {
        int[] v1 = new int[8];
        int[] v2 = new int[8];
        RandomGenerator rnd = RandomGeneratorFactory.getDefault().create();

        /* fill with one random number */
        java.util.Arrays.fill(v1, rnd.nextInt(100));
        System.out.println("v1 = " + java.util.Arrays.toString(v1));

        /* fill with random numbers */
        for (int i = 0; i < v1.length; i++) {
            v1[i] = rnd.nextInt(100);
        }
        System.out.println("v1 = " + java.util.Arrays.toString(v1));

        /* sorting */
        java.util.Arrays.sort(v1);
        System.out.println("v1 = " + java.util.Arrays.toString(v1));

        /* copying (fast!) */
        System.arraycopy(v1, 0, v2, 0, 5);
        System.out.println("v2 = " + java.util.Arrays.toString(v2));
    }
}
