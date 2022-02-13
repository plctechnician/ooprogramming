package oop.objectoriented;

public class Car {
    boolean isOn;
    String brand;
    String color;

    public Car(String brand, String color) {
        this.isOn = false;
        this.brand = brand;
        this.color = color;
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

    void turnOn() {
        this.isOn = true;
    }

    void turnOff() {
        this.isOn = false;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isOn=" + isOn +
                ", brand='" + brand + '\'' +
                ", model='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Car c1 = new Car("BWM", "M6");
        System.out.println("Identity: " + System.identityHashCode(c1));
        System.out.println("Class: " + c1.getClass().getName());
        System.out.println("State: " + c1);

        /* Implicit upcasting */
        Car[] garage = new Car[2];
        garage[0] = new Car("BWM", "M6");
        garage[1] = new SelfDrivingCar("Tesla", "Model Y");

        for (Car car : garage) {
            car.turnOn();
            /* Explicit downcasting */
            if (car instanceof SelfDrivingCar) {
                ((SelfDrivingCar) car).turnSelfDrivingOn();
            }
            /* Less explicit downcasting */
            if (car instanceof SelfDrivingCar sdcar) {
                sdcar.turnSelfDrivingOn();
            }
        }
    }
}
