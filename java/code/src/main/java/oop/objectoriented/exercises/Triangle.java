package oop.objectoriented.exercises;

/**
 * Write a class representing a Triangle
 * Methods:
 * double getArea()
 * double getPerimeter()
 *
 * @author Nicola Bicocchi
 */
public class Triangle {
    double width;
    double height;

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height / 2.0;
    }

    public double getPerimenter() {
        return width + 2 * Math.hypot(height, width / 2);
    }

    @Override
    public String toString() {
        return "Triangle{" + "width=" + width + ", height=" + height + '}';
    }
}
