package oop.objectoriented.exercises.shape;

import java.awt.*;

public class Circle extends Shape {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        super();
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
