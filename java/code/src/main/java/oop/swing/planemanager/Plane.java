package oop.swing.planemanager;

public class Plane {
    double width;
    double height;
    double wingSpan;
    String code;

    public Plane(double width, double height, double wingSpan, String code) {
        this.width = width;
        this.height = height;
        this.wingSpan = wingSpan;
        this.code = code;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toCSV() {
        return width + ";" + height + ";" + wingSpan + ";" + code;
    }

    @Override
    public String toString() {
        return "Plane{" + "width=" + width + ", height=" + height + ", wingSpan=" + wingSpan + ", code='" + code + '\'' + '}';
    }
}
