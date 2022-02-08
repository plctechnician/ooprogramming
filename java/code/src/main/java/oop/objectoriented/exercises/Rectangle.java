package oop.objectoriented.exercises;

/**
 * Write a class representing a Rectangle
 * Methods:
 * double getArea()
 * double getPerimeter()
 *
 * @author Nicola Bicocchi
 */

public class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10.0, 5.0);
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getArea());

        r1.width = 20;

        System.out.println(r1.getPerimeter());
        System.out.println(r1.getArea());

    }
}
