package oop.objectoriented.exercises.anphibious;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoatTest {
    @Test
    void run() {
        WaterVehicle w = new Boat();
        assertEquals("Boat sailing...", w.sail());
    }
}