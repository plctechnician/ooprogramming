package org.nbicocchi.oopinheritance.car;

public class Car {
    boolean isOn;
    String licensePlate;

    public Car(boolean isOn, String licensePlate) {
        this.isOn = isOn;
        this.licensePlate = licensePlate;
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
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
