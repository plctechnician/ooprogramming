package oop.objectoriented.exercises.anphibious;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnphibiousTest {
    @Test
    void sail() {
        Anphibious a = new Anphibious();
        assertEquals("Anphibious sailing...", a.sail());
        assertEquals("Anphibious sailing...", ((WaterVehicle) a).sail());
    }

    @Test
    void run() {
        Anphibious a = new Anphibious();
        assertEquals("Anphibious running...", a.run());
        assertEquals("Anphibious running...", ((LandVehicle) a).run());
    }
}