package oop.basics.exercises;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/array/index.php
 *
 * Preferences -> Editor -> General -> Code folding -> One-line methods (uncheck)
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Arrays {
    /**
     * Write a function accepting a double[] and a factor f (double)
     * returning a double[] representing the original double[] divided by f
     */
    public static double[] divideArray(double[] in, double f) {
        double[] out = new double[in.length];
        for (int i = 0; i < in.length; i++) {
            out[i] = in[i] / f;
        }
        return out;
    }

    /**
     * Write a function accepting two double[]
     * returning a double[] representing the first array divided by the second array
     * The two arrays must have the same size. Returns null otherwise.
     */
    public static double[] divideArrays(double[] a, double[] b) {
        if (a.length != b.length)
            return null;
        double[] out = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = a[i] / b[i];
        }
        return out;
    }

    /**
     * Write a function accepting an int[]
     * returning a sorted version of it (bubble sort)
     */
    public static int[] bubbleSort(int[] v) {
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
     * returning a long[] composed of the first n numbers of the Fibonacci series (without recursion).
     */
    public static long[] fibonacci(int n) {
        long[] fibonacci;
        if (n == 1) {
            fibonacci = new long[]{0};
        } else if (n == 2) {
            fibonacci = new long[]{0, 1};
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
     * Write a function accepting an int[]
     * returning an int[] in which all the 0s have been moved to the end of an array.
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

    /**
     * Write a function accepting an int
     * returning the sequence of individual digits.
     * (e.g. 363738229 -> [3,6,3,7,3,8,2,2,9])
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