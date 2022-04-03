package oop.generics.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericsTest {
    @Test
    void fill() {
        List<Integer> src = new ArrayList<>(List.of(1, 2, 3, 4));
        Generics.fill(src, 7);
        assertEquals(List.of(7, 7, 7, 7), src);
    }

    @Test
    void copy() {
        List<Integer> src = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Number> dst = new ArrayList<>(List.of(2.0, 1, 4.4, 11.54));
        Generics.copy(dst, src);
        assertEquals(List.of(1, 2, 3, 4), dst);
    }

    @Test
    void swap() {
        List<Integer> src = new ArrayList<>(List.of(1, 2, 3, 4));
        Generics.swap(src, 0, 1);
        assertEquals(List.of(2, 1, 3, 4), src);
        Generics.swap(src, 0, 3);
        assertEquals(List.of(4, 1, 3, 2), src);
    }

    @Test
    void reverse() {
        List<Integer> src = new ArrayList<>(List.of(1, 2, 3, 4));
        Generics.reverse(src);
        assertEquals(List.of(4, 3, 2, 1), src);
    }

    @Test
    void min() {
        List<Integer> src = new ArrayList<>(List.of(100, 20, 30, 40));
        assertEquals(20, Generics.min(src));
    }

    @Test
    void max() {
        List<Integer> src = new ArrayList<>(List.of(100, 20, 30, 40));
        assertEquals(100, Generics.max(src));
    }

    @Test
    void sort() {
        List<Integer> src = new ArrayList<>(List.of(100, 20, 30, 40));
        Generics.sort(src);
        assertEquals(List.of(20, 30, 40, 100), src);
    }

    @Test
    void testSort() {
        assertArrayEquals(new Integer[]{1,2,3,4,5,6}, Generics.sort(new Integer[]{3,2,5,6,4,1}));
    }

    @Test
    void divide() {
        assertEquals(0.5, Generics.divide((Integer) 1, 2.0), 0.0001);
        assertEquals(0.5, Generics.divide((Integer)1, (Integer)2), 0.0001);
        assertEquals(0.5, Generics.divide(1.0, 2.0), 0.0001);
    }

    @Test
    void countOccurrences() {
        Integer[] src;
        src = new Integer[]{1,1,2,3,45,1,1};
        assertEquals(4, Generics.countOccurrences(src, 1));
        src = new Integer[]{1,1,2,3,null,1,1};
        assertEquals(1, Generics.countOccurrences(src, null));
    }
}