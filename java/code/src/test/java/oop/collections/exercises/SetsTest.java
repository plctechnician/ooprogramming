package oop.collections.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetsTest {
    @Test
    public void testIntersection_manual() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        assertEquals(new HashSet<Integer>(Arrays.asList(4, 5, 6)), Sets.intersection_manual(s1, s2));
    }

    @Test
    public void testUnion_manual() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 8, 9));
        assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 8, 9)), Sets.union_manual(s1, s2));
    }

    @Test
    public void testIntersection() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        assertEquals(new HashSet<Integer>(Arrays.asList(4, 5, 6)), Sets.intersection(s1, s2));
    }

    @Test
    public void testUnion() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(4, 8, 9));
        assertEquals(new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 8, 9)), Sets.union(s1, s2));
    }

    @Test
    public void testToList() {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), Sets.toList(s1));
    }

    @Test
    public void testRemoveDuplicates() {
        List<Integer> s1 = Arrays.asList(1, 2, 3, 4, 5, 5, 1, 3, 4);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), Sets.removeDuplicates(s1));
    }

    @Test
    public void testRemoveDuplicates_manual() {
        List<Integer> s1 = Arrays.asList(1, 2, 3, 4, 5, 5, 1, 3, 4);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), Sets.removeDuplicates_manual(s1));
    }

    @Test
    public void testFirstRecurringCharacter() {
        assertEquals("m", Sets.firstRecurringCharacter("mamma"));
        assertEquals("e", Sets.firstRecurringCharacter("abcdee"));
    }

    @Test
    public void testAllRecurringChars() {
        assertEquals(new HashSet<Character>(Arrays.asList('m', 'a')), Sets.allRecurringChars("mamma"));
        assertEquals(new HashSet<Character>(Arrays.asList('d', 'e')), Sets.allRecurringChars("abcddee"));
    }

    @Test
    public void testToArray() {
        Set<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Sets.toArray(s));
    }

    @Test
    public void testGetFirst() {
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(1, Sets.getFirst(t));
    }

    @Test
    public void testGetLast() {
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(7, Sets.getLast(t));
    }

    @Test
    public void testTestGetGreater() {
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(6, Sets.getGreater(t, 5));
    }
}