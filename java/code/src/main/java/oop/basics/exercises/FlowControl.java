package oop.basics.exercises;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/array/index.php
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class FlowControl {
    /**
     * Write a function returning the sum of the first 100 positive integer numbers
     */
    static int sumFirstHundredNumbers() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Write a function returning the sum of the first n positive integer numbers
     */
    static int sumFirstNNumbers(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}