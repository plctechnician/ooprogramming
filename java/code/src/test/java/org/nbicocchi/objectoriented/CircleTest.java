package org.nbicocchi.objectoriented;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CircleTest {

    @Test
    public void getArea() {
        Circle c = new Circle(new Point(0, 0), 10);
        assertEquals(314.1592653589793, c.getArea(), 0.01);
    }

    @Test
    public void getPerimeter() {
        Circle c = new Circle(new Point(0, 0), 10);
        assertEquals(62.83185307179586, c.getPerimeter(), 0.01);
    }

    @Test
    public void contains() {
        Circle c = new Circle(new Point(0, 0), 10);
        assertEquals(true, c.contains(new Point(0, 0)));
        assertEquals(true, c.contains(new Point(7, 7)));
        assertEquals(false, c.contains(new Point(9, 9)));
    }
}