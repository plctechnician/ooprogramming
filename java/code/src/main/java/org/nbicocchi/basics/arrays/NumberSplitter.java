package org.nbicocchi.basics.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a Java program to break an integer into a sequence of individual
 * digits. Test Data Input six non-negative digits: 123456
 * <p>
 * Expected Output
 * <p>
 * 1 2 3 4 5 6
 *
 * @author Nicola Bicocchi
 */
public class NumberSplitter {
    public static int[] splitter(int input) {
        int n = Integer.toString(input).length();
        int[] digits = new int[n];

        for (int d = n - 1; d >= 0; d--) {
            digits[digits.length - 1 - d] = input / ((int) Math.pow(10, d)) % 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.print("Input a number: ");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        int[] digits = splitter(input);
        System.out.println(Arrays.toString(digits));
    }
}