package oop.objectoriented.exercises.shapev1;

import java.awt.*;

public class Circle extends Shape {
    Point center;
    double radius;

    public Circle(Color color, boolean filled, Point center, double radius) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
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
    public void resize(double scale) {
        radius *= scale;
    }

    @Override
    public void move(Point movement) {
        center.translate(movement.x, movement.y);
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
