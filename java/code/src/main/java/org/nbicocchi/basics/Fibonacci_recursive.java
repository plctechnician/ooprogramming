package org.nbicocchi.basics;

/**
 * Write a program to display the first n numbers of the Fibonacci series
 * (using recursion).
 *
 * @author Nicola Bicocchi
 */
public class Fibonacci_recursive {
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.printf("[id=%d, fibonacci=%d]\n", i, fibonacci(i));
        }
    }
}
