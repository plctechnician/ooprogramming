package oop.objectoriented.exercises;

import java.awt.*;

/**
 * Write a Java class representing a Circle (Point center, int radius) capable of moving on a 2D plane
 * Methods:
 * double getArea()
 * double getPerimeter()
 * double moveUp()
 * double moveDown()
 * double moveLeft()
 * double moveRight()
 * boolean contains(Point point)
 *
 * @author Nicola Bicocchi
 */
public class Circle {
    Point center;
    int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(Point point) {
        return radius > Math.hypot(point.x, point.y);
    }

    public void moveUp() {
        center.translate(0, 1);
    }

    public void moveDown() {
        center.translate(0, -1);
    }

    public void moveLeft() {
        center.translate(-1, 0);
    }

    public void moveRight() {
        center.translate(1, 0);
    }

    @Override
    public String toString() {
        return "Circle{" + "center=" + center + ", radius=" + radius + '}';
    }
}
