package org.nbicocchi.objectoriented.car;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        /* Implicit upcasting */
        Car[] garage = new Car[2];
        garage[0] = new Car("BWM", "M6");
        garage[1] = new SelfDrivingCar("Tesla", "Model Y");

        for (Car c : garage) {
            c.turnOn();
            if (c instanceof SelfDrivingCar) {
                ((SelfDrivingCar) c).turnSelfDrivingOn();
            }
            System.out.println(c);
        }
    }
}
