package oop.objectoriented.exercises.shapev2;

import java.awt.*;

public interface Shape {
    double getPerimeter();
    double getArea();
    void move(Point movement);
    void resize(double scale);
}
