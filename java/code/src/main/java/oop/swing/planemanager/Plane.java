package oop.swing.planemanager;

import java.time.LocalDate;

public class Plane {
    String name;
    double length;
    double wingspan;
    LocalDate firstFlight;
    String category;

    public Plane(String name, double length, double wingspan, LocalDate firstFlight, String category) {
        this.name = name;
        this.length = length;
        this.wingspan = wingspan;
        this.firstFlight = firstFlight;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public LocalDate getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(LocalDate firstFlight) {
        this.firstFlight = firstFlight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toCSV() {
        return name + ";" + length + ";" + wingspan + ";" + firstFlight + ";" + category;
    }

    @Override
    public String toString() {
        return "Plane{" + "name='" + name + '\'' + ", length=" + length + ", wingspan=" + wingspan + ", firstFlight=" + firstFlight + ", category='" + category + '\'' + '}';
    }
}
