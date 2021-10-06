package org.nbicocchi.objectoriented.movableshape;

import java.awt.*;

public class MovableRectangle implements Movable {
    Point topLeft;
    Point bottomRight;

    public MovableRectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public void moveUp() {
        topLeft.translate(0, 1);
        bottomRight.translate(0, 1);
    }

    @Override
    public void moveDown() {
        topLeft.translate(0, -1);
        bottomRight.translate(0, -1);
    }

    @Override
    public void moveLeft() {
        topLeft.translate(-1, 0);
        bottomRight.translate(-1,0);
    }

    @Override
    public void moveRight() {
        topLeft.translate(1,0);
        bottomRight.translate(1,0);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }
}
