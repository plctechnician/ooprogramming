package oop.collections.exercises;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MapsTest {

    @Test
    public void count() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertEquals(3, Maps.count(map));
    }

    @Test
    public void empty() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Maps.empty(map);
        assertEquals(0, map.size());
    }

    @Test
    public void contains() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertTrue(Maps.contains(map, 1));
        assertFalse(Maps.contains(map, 5));
    }

    @Test
    public void keySet() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        assertArrayEquals(set.toArray(), Maps.keySet(map).toArray());
    }

    @Test
    public void getColor() {
        assertEquals("black", Maps.getColor(0));
        assertEquals("white", Maps.getColor(1));
        assertEquals("red", Maps.getColor(2));
    }
}