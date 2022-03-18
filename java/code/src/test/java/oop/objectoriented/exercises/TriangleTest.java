package oop.objectoriented.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void getArea() {
        Triangle t = new Triangle(10, 10);
        assertEquals(50, t.getArea());
    }

    @Test
    void getPerimenter() {
        Triangle t = new Triangle(10, 10);
        assertEquals(32.3606, t.getPerimeter(), 0.01);
    }
}