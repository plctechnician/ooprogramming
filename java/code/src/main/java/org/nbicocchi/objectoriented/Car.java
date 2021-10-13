package org.nbicocchi.objectoriented;

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

    public static void main(String[] args) {
        /* Implicit upcasting */
        Car[] garage = new Car[2];
        garage[0] = new Car("BWM", "M6");
        garage[1] = new SelfDrivingCar("Tesla", "Model Y");

        for (Car c : garage) {
            c.turnOn();
            if (c instanceof SelfDrivingCar) {
                /* Explicit downcasting */
                ((SelfDrivingCar) c).turnSelfDrivingOn();
            }
            System.out.println(c);
        }
    }
}
