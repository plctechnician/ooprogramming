package oop.collections.exercises.mylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyList l;

    @BeforeEach
    void setUp() {
        l = new MyLinkedList();
    }

    @Test
    void add() {
        l.add("nicola");
        assertEquals("nicola", l.get(0));
        l.add("barbara", 0);
        assertEquals("barbara", l.get(0));
        assertEquals("nicola", l.get(1));
        assertEquals(2, l.size());
    }

    @Test
    void get() {
        l.add("nicola");
        assertEquals("nicola", l.get(0));
    }

    @Test
    void remove() {
        l.add("nicola");
        assertEquals("nicola", l.get(0));
        l.add("barbara", 0);
        l.remove(0);
        assertEquals("nicola", l.get(0));
        assertEquals(1, l.size());
    }

    @Test
    void size() {
        assertEquals(0, l.size());
        l.add("nicola");
        assertEquals(1, l.size());
    }
}