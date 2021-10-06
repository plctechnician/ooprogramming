package org.nbicocchi.objectoriented.shape;

import java.awt.*;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(new Point(0,0), 10);
        shapes[1] = new Rectangle(new Point(-10, 10), new Point(0,0));

        for (Shape s : shapes) {
            System.out.printf("area=%f, perimeter=%f\n", s.getArea(), s.getPerimeter());
        }
    }
}
