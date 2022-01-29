package oop.basics;

import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        Random rnd = new Random();

        /* integer numbers */
        System.out.println(rnd.nextInt());
        System.out.println(rnd.nextLong());

        /* floating point numbers */
        System.out.println(rnd.nextFloat());
        System.out.println(rnd.nextDouble());

        /* boolean values */
        System.out.println(rnd.nextBoolean());
    }
}
