package org.nbicocchi.objectoriented.exercises.anphibious;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        LandVehicle l = new Car();
        l.run();

        WaterVehicle w = new Boat();
        w.sail();

        Anphibious a = new Anphibious();
        a.run();
        a.sail();
    }
}