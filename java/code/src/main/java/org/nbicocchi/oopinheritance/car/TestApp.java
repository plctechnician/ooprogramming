package org.nbicocchi.oopinheritance.car;

/**
 * Implementare le classi rappresentate in UML all'interno del file .png
 * presente nel package e testarle con il main() sottostante.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        /* Implicit form of upcasting */
        Car[] garage = new Car[3];
        garage[0] = new Car(false, "Fiat", "Red");
        garage[1] = new Car(false,"BWM", "M6");
        garage[2] = new SDCar(false,"Rimac", "Concept One", false);

        for (Car c : garage) {
            System.out.println(c);
        }
    }
}
