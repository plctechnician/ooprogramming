package org.nbicocchi.objectoriented.movableshape;

import java.awt.*;

public class MovableCircle implements Movable {
    int radius;
    Point center;

    public MovableCircle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() {
        center.translate(0, 1);
    }

    @Override
    public void moveDown() {
        center.translate(0, -1);
    }

    @Override
    public void moveLeft() {
        center.translate(-1, 0);
    }

    @Override
    public void moveRight() {
        center.translate(1, 0);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
