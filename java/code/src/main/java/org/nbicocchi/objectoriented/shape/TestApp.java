package org.nbicocchi.objectoriented.shape;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Shape[] v = new Shape[4];
        v[0] = new Circle("Red", true, 2);
        v[1] = new Circle(3);
        v[2] = new Rectangle(2, 3);
        v[3] = new Square(3);

        for (Shape s : v) {
            System.out.println(s);

            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                System.out.println(r.getWidth());
                System.out.println(r.getHeight());
            }
        }
    }
}
