package org.nbicocchi.objectoriented;

import java.awt.*;
import java.util.Arrays;

/**
 * Write a class named Polygon representing an irregular polygon.
 * Internally, the class represents an irregular polygon as an array of 2d points (vertices).
 *
 * Supported methods:
 * int getVerticesNumber() - returns the number of vertices
 * Point[] getVertices() - returns the array of vertices
 * void move(Point movement) - moves the polygon as specified by movement (treated as a vector)
 * double getArea() - returns the area of the polygon, computed using the formula that cna be found here( https://arachnoid.com/area_irregular_polygon/index.html)
 *
 * @author Nicola Bicocchi
 */
public class Polygon {
    Point[] vertices;

    public Polygon(Point[] vertices) {
        this.vertices = vertices;
    }

    public int getVerticesNumber() {
        return vertices.length;
    }

    public Point[] getVertices() {
        return vertices;
    }

    public void move(Point movement) {
        for (Point vertex : vertices) {
            vertex.translate(movement.x, movement.y);
        }
    }

    public double getArea() {
        double sum = 0;
        for (int i = 0; i < vertices.length; i++) {
            int next = (i + 1) % vertices.length;
            sum += 0.5 * (vertices[i].x * vertices[next].y) - (vertices[i].y * vertices[next].x);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "vertices=" + Arrays.toString(vertices) +
                '}';
    }

    public static void main(String[] args) {
        Point[] vertices = {new Point(0,0), new Point(10, 0), new Point(5, 10)};
        Polygon p = new Polygon(vertices);
        System.out.println(p.getVerticesNumber());
        System.out.println(p.getArea());
        p.move(new Point(-5, -10));
        System.out.println(p);
    }
}
