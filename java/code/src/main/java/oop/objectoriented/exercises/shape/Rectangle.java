package oop.objectoriented.exercises.shape;

import java.awt.*;

public class Rectangle extends Shape {
    Point upperLeft;
    Point bottomRight;

    public Rectangle(Point upperLeft, Point bottomRight) {
        super();
        this.upperLeft = upperLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public double getPerimeter() {
        return ((bottomRight.x - upperLeft.x) + (upperLeft.y - bottomRight.y)) * 2;
    }

    @Override
    public double getArea() {
        return (bottomRight.x - upperLeft.x) * (upperLeft.y - bottomRight.y);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "upperLeft=" + upperLeft +
                ", bottomRight=" + bottomRight +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
