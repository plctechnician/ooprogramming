package org.nbicocchi.objectoriented.resizableshape;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println(c);
        c.resize(2);
        System.out.println(c);
    }
}
