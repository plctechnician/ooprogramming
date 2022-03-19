package oop.objectoriented.exercises.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineBestTest {
    @Test
    void reverse() {
        Reverser r = new EngineBest();
        assertEquals("!dlroW olleH", r.reverse("Hello World!"));
    }
}