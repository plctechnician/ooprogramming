package org.nbicocchi.objectoriented.car;

public class SDCar extends Car {
    boolean isSelfDriving;

    public SDCar(boolean isOn, String brand, String color, boolean isSelfDriving) {
        super(isOn, brand, color);
        this.isSelfDriving = isSelfDriving;
    }

    @Override
    void turnOn() {
        isSelfDriving = false;
        super.turnOn();
    }

    @Override
    void turnOff() {
        isSelfDriving = false;
        super.turnOff();
    }

    void turnSDOn() {
        isSelfDriving = true;
    }

    void turnSDOff() {
        isSelfDriving = false;
    }

    @Override
    public String toString() {
        return "SDCar{" +
                "isOn=" + isOn +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", isSelfDriving=" + isSelfDriving +
                '}';
    }
}
