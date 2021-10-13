package org.nbicocchi.objectoriented;

public class SelfDrivingCar extends Car {
    boolean isSelfDriving;

    public SelfDrivingCar(String brand, String model) {
        super(brand, model);
        this.isSelfDriving = false;
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

    void turnSelfDrivingOn() {
        isSelfDriving = true;
    }

    void turnSelfDrivingOff() {
        isSelfDriving = false;
    }

    @Override
    public String toString() {
        return "SelfDrivingCar{" +
                "isOn=" + isOn +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", isSelfDriving=" + isSelfDriving +
                '}';
    }
}
