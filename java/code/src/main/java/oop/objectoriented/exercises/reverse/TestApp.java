package oop.objectoriented.exercises.reverse;

/**
 * Use the Reverser Interface to provide the following main() with
 * three different (but interchangeable) methods for reversing a String.
 * This use of polymorphism is widely diffused in real-world software!
 */

public class TestApp {
    public static void main(String[] args) {
        Reverser r = new EngineBest();
        //Reverser r = new EngineFast();
        //Reverser r = new EngineSlow();

        //Using lambda expressions
        //Reverser r = (String s) -> new StringBuilder(s).reverse().toString();

        System.out.println(r.reverse("Hello World!"));
    }
}
