package oop.collections.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ListsTest {
    @Test
    public void testInsertFirst() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.insertFirst(l, 99);
        assertEquals(Arrays.asList(99, 5, 1, 12, 44, 7), l);
    }

    @Test
    public void testInsertLast() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.insertLast(l, 99);
        assertEquals(Arrays.asList(5, 1, 12, 44, 7, 99), l);
    }

    @Test
    public void testReplace() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.replace(l, 99);
        assertEquals(Arrays.asList(5, 1, 99, 44, 7), l);
    }

    @Test
    public void testRemoveThird() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.removeThird(l);
        assertEquals(Arrays.asList(5, 1, 44, 7), l);
    }

    @Test
    public void testRemoveEvil() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 666, 7));
        Lists.removeEvil(l);
        assertEquals(Arrays.asList(5, 1, 12, 7), l);
    }

    @Test
    public void testGenerateSquare() {
        assertEquals(Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), Lists.generateSquare());
    }

    @Test
    public void testContains() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        assertTrue(Lists.contains(l, 12));
        assertFalse(Lists.contains(l, 3));
    }

    @Test
    public void testCopy() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        Lists.copy(l, l2);
        assertEquals(l, l2);
    }

    @Test
    public void testReverse() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.reverse(l);
        assertEquals(Arrays.asList(7, 44, 12, 1, 5), l);
    }

    @Test
    public void testReverseManual() {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.reverseManual(l);
        assertEquals(Arrays.asList(7, 44, 12, 1, 5), l);
    }

    @Test
    public void testInsertBeginningEnd() {
        LinkedList<Integer> l = new LinkedList<>(Arrays.asList(5, 1, 12, 44, 7));
        Lists.insertBeginningEnd(l, 77);
        assertEquals(Arrays.asList(77, 5, 1, 12, 44, 7, 77), l);
    }
}