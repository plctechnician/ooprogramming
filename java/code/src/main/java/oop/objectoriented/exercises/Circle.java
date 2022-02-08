package oop.objectoriented.exercises;

import java.awt.*;

/**
 * Write a Java class representing a moving Circle (Point center, int radius)
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

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public boolean contains(Point point) {
        return radius > Math.hypot(point.x, point.y);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public static void main(String[] args) {
        Circle c = new Circle(new Point(0, 0), 10);
        System.out.println(c);
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());
        System.out.println(c.contains(new Point(5, 5)));
        System.out.println(c.contains(new Point(9, 9)));
    }
}
