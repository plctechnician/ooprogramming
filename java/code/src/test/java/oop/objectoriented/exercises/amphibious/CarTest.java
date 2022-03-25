package oop.objectoriented.exercises.amphibious;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void run() {
        LandVehicle c = new Car();
        assertEquals("Car running...", c.run());
    }
}