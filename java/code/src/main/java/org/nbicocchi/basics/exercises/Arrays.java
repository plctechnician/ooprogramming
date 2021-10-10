package org.nbicocchi.basics.exercises;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/array/index.php
 */
public class Arrays {
    /**
     * Write a function accepting an int[]
     * an returning a sorted version of it (bubble sort)
     */
    static int[] bubbleSort(int[] v) {
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
        return v;
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

    /**
     * Write a function accepting an int
     * and returning an array long[] composed
     * of the first n numbers of the Fibonacci series
     * (without recursion).
     */
    public static long[] fibonacci(int n) {
        long[] fibonacci = null;

        if (n == 1) {
            fibonacci = new long[] {0};
        } else if (n == 2) {
            fibonacci = new long[] {0, 1};
        } else {
            fibonacci = new long[n];
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i < n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
        }
        return fibonacci;
    }

    /**
     * * Write a function accepting an int[]
     * and returning an int[] in which all the
     * 0s have been moved to the end of an array.
     * Maintain the relative order of the other (non-zero) elements.
     */
    public static int[] moveZerosEnd(int[] v) {
        int[] output = new int[v.length];
        int i, j = 0;

        for (i = 0; i < v.length; i++) {
            if (v[i] != 0) {
                output[j++] = v[i];
            }
        }

        // fills with remaining zeros
        for (; j < output.length; j++) {
            output[j] = 0;
        }
        return output;
    }
}