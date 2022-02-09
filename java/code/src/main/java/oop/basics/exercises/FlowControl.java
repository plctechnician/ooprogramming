package oop.basics.exercises;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/basic/index.php
 * https://www.w3resource.com/java-exercises/basic/index1.php
 *
 * Preferences -> Editor -> General -> Code folding -> One-line methods (uncheck)
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class FlowControl {
    /**
     * Write a function returning the sum of the first n positive integer numbers
     */
    static int sumFirstNumbers(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}