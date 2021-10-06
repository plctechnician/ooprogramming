package org.nbicocchi.objectoriented;

/**
 * Write a Java class representing a Circle (x, y, r). Inside the class, define
 * a static attribute representing PI. Create two objects, c1 and c2, of class
 * Circle.
 * <p>
 * Verify what happens when PI is accessed as a class attribute or, instead, as
 * an object attribute (using c1 or c2).
 *
 * @author Nicola Bicocchi
 */

public class Circle {
    public static double PI = 3.14159;
    double center_x;
    double center_y;
    double radius;

    public Circle(double center_x, double center_y, double radius) {
        this.center_x = center_x;
        this.center_y = center_y;
        this.radius = radius;
    }

    public double getCenter_x() {
        return center_x;
    }

    public void setCenter_x(double center_x) {
        this.center_x = center_x;
    }

    public double getCenter_y() {
        return center_y;
    }

    public void setCenter_y(double center_y) {
        this.center_y = center_y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(2, 2, 4);
        Circle c2 = new Circle(2, 2, 4);

        System.out.println(c1.PI);
        System.out.println(c2.PI);

        Circle.PI = 3.1;

        System.out.println(c1.PI);
        System.out.println(c2.PI);
    }
}
