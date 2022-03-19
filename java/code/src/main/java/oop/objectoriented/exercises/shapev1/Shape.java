package oop.objectoriented.exercises.shapev1;

import java.awt.*;

public abstract class Shape {
    Color color;
    boolean filled;

    public Shape(Color color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void move(Point movement);
    public abstract void resize(double scale);
}
