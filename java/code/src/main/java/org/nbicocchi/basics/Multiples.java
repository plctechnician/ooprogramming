package org.nbicocchi.basics;

import java.util.Scanner;

/**
 * Write a program accepting 3 integer parameters: x, y, n.
 * The program shows all the integers numbers in the range [1, n] divisible by x and y
 *
 * @author Nicola Bicocchi
 */
public class Multiples {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("x: ");
        int x = in.nextInt();
        System.out.print("y: ");
        int y = in.nextInt();
        System.out.print("n: ");
        int n = in.nextInt();
        in.close();

        for (int i = 1; i <= n; i++) {
            if (i % x == 0 && i % y == 0) {
                System.out.println(i);
            }
        }
    }

}
