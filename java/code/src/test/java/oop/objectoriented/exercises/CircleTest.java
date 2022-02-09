package oop.objectoriented.exercises;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void moveUp() {
        Circle c = new Circle(new Point(0, 0), 10);
        c.moveUp();
        assertEquals(0, c.center.x);
        assertEquals(1, c.center.y);
    }

    @Test
    void moveDown() {
        Circle c = new Circle(new Point(0, 0), 10);
        c.moveDown();
        assertEquals(0, c.center.x);
        assertEquals(-1, c.center.y);
    }

    @Test
    void moveLeft() {
        Circle c = new Circle(new Point(0, 0), 10);
        c.moveLeft();
        assertEquals(-1, c.center.x);
        assertEquals(0, c.center.y);
    }

    @Test
    void moveRight() {
        Circle c = new Circle(new Point(0, 0), 10);
        c.moveRight();
        assertEquals(1, c.center.x);
        assertEquals(0, c.center.y);
    }
}