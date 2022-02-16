package oop.objectoriented.exercises.reverse;

/**
 * Use the Reverser Interface to provide the following main() with
 * three different (but interchangeable) objects for reversing a String.
 * The reverse() method accepts a String and returns the same String, but inverted.
 * EngineSlow uses String.charAt() and String concatenation
 * EngineFast uses StringBuilder() instead of String concatenation
 * EngineBest uses StringBuilder() only
 */

public class TestApp {
    public static void main(String[] args) {
        Reverser r = new EngineBest();
        //Reverser r = new EngineFast();
        //Reverser r = new EngineSlow();

        //One line version with lambda expressions
        //Reverser r = (String s) -> new StringBuilder(s).reverse().toString();

        System.out.println(r.reverse("Hello World!"));
    }
}
