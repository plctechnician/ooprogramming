package oop.objectoriented.exercises.shapev1;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    @Test
    void getColor() {
        Shape s = new Circle(Color.BLACK, true, new Point(0,0), 10);
        assertEquals(Color.BLACK, s.getColor());
    }

    @Test
    void setColor() {
        Shape s = new Circle(Color.BLACK, true, new Point(0,0), 10);
        s.setColor(Color.YELLOW);
        assertEquals(Color.YELLOW, s.getColor());
    }

    @Test
    void isFilled() {
        Shape s = new Circle(Color.BLACK, true, new Point(0,0), 10);
        assertTrue(s.isFilled());
    }

    @Test
    void setFilled() {
        Shape s = new Circle(Color.BLACK, true, new Point(0,0), 10);
        s.setFilled(false);
        assertFalse(s.isFilled());
    }

    @Test
    void getPerimeter() {
        Circle s = new Circle(Color.BLACK, true, new Point(0,0), 10);
        assertEquals(62.831853, s.getPerimeter(), 0.01);
    }

    @Test
    void getArea() {
        Circle s = new Circle(Color.BLACK, true, new Point(0,0), 10);
        assertEquals(314.159265, s.getArea(), 0.01);
    }
}