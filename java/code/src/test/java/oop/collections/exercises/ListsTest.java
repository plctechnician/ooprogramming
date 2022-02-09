package oop.collections.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListsTest {
    @Test
    public void insertFirst() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        Lists.insertFirst(l, 99);
        assertEquals(List.of(99, 5, 1, 12, 44, 7), l);
    }

    @Test
    public void insertLast() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        Lists.insertLast(l, 99);
        assertEquals(List.of(5, 1, 12, 44, 7, 99), l);
    }

    @Test
    public void replace() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        Lists.replace(l, 99);
        assertEquals(List.of(5, 1, 99, 44, 7), l);
    }

    @Test
    public void removeThird() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        Lists.removeThird(l);
        assertEquals(List.of(5, 1, 44, 7), l);
    }

    @Test
    public void removeEvil() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 666, 7));
        Lists.removeEvil(l);
        assertEquals(List.of(5, 1, 12, 7), l);
    }

    @Test
    public void generateSquare() {
        assertEquals(List.of(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), Lists.generateSquare());
    }

    @Test
    public void contains() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        assertTrue(Lists.contains(l, 12));
        assertFalse(Lists.contains(l, 3));
    }

    @Test
    public void copy() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        ArrayList<Integer> l2 = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        Lists.copy(l, l2);
        assertEquals(l, l2);
    }

    @Test
    public void reverse() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        Lists.reverse(l);
        assertEquals(List.of(7, 44, 12, 1, 5), l);
    }

    @Test
    public void reverseManual() {
        ArrayList<Integer> l = new ArrayList<>(List.of(5, 1, 12, 44, 7));
        Lists.reverseManual(l);
        assertEquals(List.of(7, 44, 12, 1, 5), l);
    }

    @Test
    public void insertBeginningEnd() {
        LinkedList<Integer> l = new LinkedList<>(List.of(5, 1, 12, 44, 7));
        Lists.insertBeginningEnd(l, 77);
        assertEquals(List.of(77, 5, 1, 12, 44, 7, 77), l);
    }
}