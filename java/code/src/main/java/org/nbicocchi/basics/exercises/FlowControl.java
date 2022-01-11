package org.nbicocchi.basics.exercises;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/array/index.php
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class FlowControl {

    /**
     * Write a function printing all integer numbers divisible by 7 comprised between 0 and 100
     */
    static void divisibleBy7() {
        for (int i = 0; i < 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * Write a function returning the sum of the first 100 positive integer numbers
     */
    static int sumFirst100Numbers() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}