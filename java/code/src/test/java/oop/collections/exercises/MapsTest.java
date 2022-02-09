package oop.collections.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapsTest {
    @Test
    public void testCount() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertEquals(3, Maps.count(map));
    }

    @Test
    public void testEmpty() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Maps.empty(map);
        assertEquals(0, map.size());
    }

    @Test
    public void testContains() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertTrue(Maps.contains(map, 1));
        assertFalse(Maps.contains(map, 5));
    }

    @Test
    public void testKeySet() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
        assertArrayEquals(set.toArray(), Maps.keySet(map).toArray());
    }

    @Test
    public void testValues() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        Collection<Integer> c = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertArrayEquals(c.toArray(), Maps.values(map).toArray());
    }

    @Test
    public void testGetColor() {
        assertEquals("black", Maps.getColor(0));
        assertEquals("white", Maps.getColor(1));
        assertEquals("red", Maps.getColor(2));
    }
}