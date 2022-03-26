package oop.generics.exercises.mycollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest extends MyListTestBase {
    @BeforeEach
    void setUp() {
        l = new MyLinkedList<>();
    }

    @Test
    void peek() {
        MyLinkedList<String> ll = new MyLinkedList<>();
        ll.add("nicola");
        ll.add("marzia");
        assertEquals("nicola", ll.peek());
        assertEquals("nicola", ll.peek());
        assertEquals(2, ll.size());
    }

    @Test
    void poll() {
        MyLinkedList<String> ll = new MyLinkedList<>();
        ll.add("nicola");
        ll.add("marzia");
        assertEquals("nicola", ll.poll());
        assertEquals("marzia", ll.poll());
        assertEquals(0, ll.size());
    }
}