package oop.collections.exercises;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ListsTest {

    @Test
    public void insertFirst() {
        List<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.insertFirst(l, 99);
        assertEquals(99, (long) l.get(0));
    }

    @Test
    public void replace() {
        List<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.replace(l, 99);
        assertEquals(99, (long) l.get(2));
    }

    @Test
    public void removeThird() {
        List<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.removeThird(l);
        assertEquals(44, (long) l.get(2));
    }

    @Test
    public void contains() {
        List<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        assertTrue(l.contains(12));
        assertFalse(l.contains(3));
    }

    @Test
    public void copy() {
        List<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        Lists.copy(l, l2);
        assertTrue(l.equals(l2));
    }

    @Test
    public void reverse() {
        List<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.reverse(l);
        assertEquals(7, (long) l.get(0));
        assertEquals(44, (long) l.get(1));
        assertEquals(12, (long) l.get(2));
    }

    @Test
    public void insertBeginningEnd() {
        LinkedList<Integer> l = new LinkedList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.insertBeginningEnd(l, 77);
        assertEquals(77, (long) l.get(0));
        assertEquals(77, (long) l.get(6));
    }
}