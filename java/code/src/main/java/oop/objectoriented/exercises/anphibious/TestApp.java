package oop.objectoriented.exercises.anphibious;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        LandVehicle l = new Car();
        System.out.println(l.run());

        WaterVehicle w = new Boat();
        System.out.println(w.sail());

        Anphibious a = new Anphibious();
        System.out.println(a.run());
        System.out.println(a.sail());
    }
}