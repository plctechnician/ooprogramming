package org.nbicocchi.oopinheritance.car;

public class SDCar extends Car {
    boolean isSelfDriving;

    public SDCar(boolean isOn, String licensePlate, boolean isSelfDriving) {
        super(isOn, licensePlate);
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
                ", licensePlate='" + licensePlate + '\'' +
                ", isSelfDriving=" + isSelfDriving +
                '}';
    }
}
