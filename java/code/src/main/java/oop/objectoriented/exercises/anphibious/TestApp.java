package oop.objectoriented.exercises.anphibious;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        LandVehicle l;
        WaterVehicle w;

        l = new Car();
        System.out.println(l.run());

        w = new Boat();
        System.out.println(w.sail());

        l = new Anphibious();
        System.out.println(l.run());

        w = new Anphibious();
        System.out.println(w.sail());
    }
}