package oop.collections.exercises.mycollection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class MySetTestBase {
    MySet s;

    @Test
    void add() {
        s.add("nicola");
        assertTrue(s.contains("nicola"));
        assertFalse(s.contains("marzia"));
    }

    @Test
    void remove() {
        s.add("nicola");
        s.add("marzia");
        s.remove("nicola");
        assertEquals(1, s.size());
        s.remove("marzia");
        assertEquals(0, s.size());
    }

    @Test
    void size() {
        assertEquals(0, s.size());
        s.add("nicola");
        assertEquals(1, s.size());
        s.add("nicola");
        assertEquals(1, s.size());
        s.add("marzia");
        assertEquals(2, s.size());
    }

    @Test
    void contains() {
        s.add("nicola");
        assertTrue(s.contains("nicola"));
        s.add("nicola");
        s.add("marzia");
        assertTrue(s.contains("marzia"));
        s.remove("marzia");
        assertFalse(s.contains("marzia"));
    }
}