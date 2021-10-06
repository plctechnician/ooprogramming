package org.nbicocchi.objectoriented.movableshape;

import java.awt.Point;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Movable[] v = new Movable[2];
        v[0] = new MovableRectangle(new Point(0, 10), new Point(20, 0));
        v[1] = new MovableCircle(10, new Point(0,0));

        for (Movable m : v) {
            m.moveRight();
            m.moveUp();
            System.out.println(m);
        }
    }
}
