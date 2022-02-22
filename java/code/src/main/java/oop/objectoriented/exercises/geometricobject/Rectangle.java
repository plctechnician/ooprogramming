package oop.objectoriented.exercises.geometricobject;

import java.awt.*;

public class Rectangle implements GeometricObject, Resizable, Movable {
    Point upperLeft;
    Point bottomRight;

    public Rectangle(Point upperLeft, Point bottomRight) {
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
    public void resize(double scale) {
        bottomRight.x = (int) (upperLeft.x + ((bottomRight.x - upperLeft.x) * scale));
        bottomRight.y = (int) (upperLeft.y - ((upperLeft.y - bottomRight.y) * scale));
    }

    @Override
    public void move(Point movement) {
        upperLeft.translate(movement.x, movement.y);
        bottomRight.translate(movement.x, movement.y);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "upperLeft=" + upperLeft + ", bottomRight=" + bottomRight + '}';
    }
}
