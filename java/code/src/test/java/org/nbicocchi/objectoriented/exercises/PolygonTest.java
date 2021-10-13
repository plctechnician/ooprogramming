package org.nbicocchi.objectoriented.exercises;

import org.junit.Test;
import org.nbicocchi.objectoriented.exercises.Polygon;

import java.awt.*;

import static org.junit.Assert.*;

public class PolygonTest {

    @Test
    public void getVerticesNumber() {
        Point[] vertices = {new Point(0,0), new Point(10, 0), new Point(10, 10)};
        org.nbicocchi.objectoriented.exercises.Polygon p = new org.nbicocchi.objectoriented.exercises.Polygon(vertices);
        assertEquals(3, p.getVerticesNumber());
    }

    @Test
    public void getVertices() {
    }

    @Test
    public void move() {
        Point[] vertices = {new Point(0,0), new Point(10, 0), new Point(10, 10)};
        org.nbicocchi.objectoriented.exercises.Polygon p = new org.nbicocchi.objectoriented.exercises.Polygon(vertices);
        p.move(new Point(-5, -5));
        assertEquals(new Point(-5, -5), p.getVertices()[0]);
        assertEquals(new Point(5, -5), p.getVertices()[1]);
        assertEquals(new Point(5, 5), p.getVertices()[2]);
    }

    @Test
    public void getArea() {
        Point[] vertices = {new Point(0,0), new Point(10, 0), new Point(10, 10)};
        org.nbicocchi.objectoriented.exercises.Polygon p = new Polygon(vertices);
        assertEquals(50.0, p.getArea(), 0.01);
    }
}