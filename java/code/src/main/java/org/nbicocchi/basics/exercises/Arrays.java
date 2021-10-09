package org.nbicocchi.basics.exercises;

public class Arrays {
    /**
     * Write a function accepting an int[]
     * an returning a sorted version of it (bubble sort)
     */
    static void bubbleSort(int[] v) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    changed = true;
                    int tmp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = tmp;
                }
            }
        }
    }

    /**
     * Write a function accepting an int
     * and returning the sequence of individual digits.
     */
    public static int[] splitter(int input) {
        int n = Integer.toString(input).length();
        int[] digits = new int[n];

        for (int d = n - 1; d >= 0; d--) {
            digits[digits.length - 1 - d] = input / ((int) Math.pow(10, d)) % 10;
        }
        return digits;
    }
}