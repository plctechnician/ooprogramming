package org.nbicocchi.objectoriented.exercises.resizableshape;

import java.awt.Point;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        GeometricObject[] geometricObjects = new GeometricObject[2];
        Resizable[] resizables = new Resizable[2];

        Circle c1 = new Circle(new Point(0,0),10);
        Rectangle r1 = new Rectangle(new Point(-20,20),new Point(0,0));

        geometricObjects[0] = c1;
        geometricObjects[1] = r1;

        resizables[0] = c1;
        resizables[1] = r1;

        for (GeometricObject go : geometricObjects) {
            System.out.println(go.getArea());
            System.out.println(go.getPerimeter());
        }

        for (Resizable r : resizables) {
            r.resize(0.5);
        }

        System.out.println(c1);
        System.out.println(r1);
    }
}
