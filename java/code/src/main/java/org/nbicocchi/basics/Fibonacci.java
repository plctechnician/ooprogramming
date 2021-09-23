package org.nbicocchi.basics;

/**
 * Write a program to display the first n numbers of the Fibonacci series
 * (without recursion).
 *
 * @author Nicola Bicocchi
 */
public class Fibonacci {
    public static long[] fibonacci(int n) {
        long[] fibonacci = new long[n];

        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public static void main(String[] args) {
        long[] series = fibonacci(50);

        for (int i = 0; i < series.length; i++) {
            System.out.printf("[id=%d, fibonacci=%d]\n", i, series[i]);
        }
    }
}
