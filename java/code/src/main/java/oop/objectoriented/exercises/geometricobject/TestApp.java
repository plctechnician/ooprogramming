package oop.objectoriented.exercises.geometricobject;

import java.awt.Point;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Object[] geometricObjects = new Object[3];

        geometricObjects[0] = new Circle(new Point(0,0),10);;
        geometricObjects[1] = new Rectangle(new Point(-20,20),new Point(0,0));;
        geometricObjects[2] = new Rectangle(new Point(-10,10),new Point(10,-10));;

        for (Object o : geometricObjects) {
            if (o instanceof Resizable ro) {
                ro.resize(0.5);
            }
            if (o instanceof Movable mo) {
                mo.move(new Point(2,-2));
            }
        }

        for (Object o : geometricObjects) {
            if (o instanceof GeometricObject go) {
                System.out.println(o);
            }
        }
    }
}
