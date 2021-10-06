package org.nbicocchi.objectoriented.car;

public class Car {
    boolean isOn;
    String brand;
    String model;

    public Car(String brand, String model) {
        this.isOn = false;
        this.brand = brand;
        this.model = model;
    }

    void turnOn() {
        isOn = true;
    }

    void turnOff() {
        isOn = false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isOn=" + isOn +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
