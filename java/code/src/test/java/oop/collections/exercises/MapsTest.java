package oop.collections.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapsTest {
    @Test
    public void count() {
        Map<Integer, Integer> map = new HashMap<>(Map.of(1,1,2,2,3,3));
        assertEquals(3, Maps.count(map));
    }

    @Test
    public void empty() {
        Map<Integer, Integer> map = new HashMap<>(Map.of(1,1,2,2,3,3));
        Maps.empty(map);
        assertEquals(0, map.size());
    }

    @Test
    public void contains() {
        Map<Integer, Integer> map = new HashMap<>(Map.of(1,1,2,2,3,3));
        assertTrue(Maps.contains(map, 1));
        assertFalse(Maps.contains(map, 5));
    }

    @Test
    public void keySet() {
        Map<Integer, Integer> map = new HashMap<>(Map.of(1,1,2,2,3,3));
        assertEquals(Set.of(1,2,3), Maps.keySet(map));
    }

    @Test
    public void values() {
        Map<Integer, Integer> map = new HashMap<>(Map.of(1,1,2,2,3,3));
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<>(Maps.values(map)));
    }

    @Test
    public void getColor() {
        assertEquals("black", Maps.getColor(0));
        assertEquals("white", Maps.getColor(1));
        assertEquals("red", Maps.getColor(2));
    }
}