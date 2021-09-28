package org.nbicocchi.generics;

public class CovariantArray {
    public static void main(String[] args) {
        Fruit[] fl = new Fruit[16];
        Object[] ol = fl;

        for (int i = 0; i < fl.length; i++) {
            fl[i] = new Fruit();
        }

        // Compiles but fails at runtime!
        ol[0] = "Hello World!";
    }
}
