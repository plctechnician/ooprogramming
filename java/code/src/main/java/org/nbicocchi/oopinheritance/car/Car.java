package org.nbicocchi.oopinheritance.car;

public class Car {
    boolean isOn;
    String brand;
    String color;

    public Car(boolean isOn, String brand, String color) {
        this.isOn = isOn;
        this.brand = brand;
        this.color = color;
    }

    void turnOn() {
        isOn = false;
    }

    void turnOff() {
        isOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isOn=" + isOn +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
