package oop.objectoriented.exercises.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineSlowTest {
    @Test
    void reverse() {
        Reverser r = new EngineSlow();
        assertEquals("!dlroW olleH", r.reverse("Hello World!"));
    }
}