package oop.collections.exercises;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetsTest {
    @Test
    public void intersection_manual() {
        Set<Integer> s1 = Set.of(1, 2, 3, 4, 5, 6);
        Set<Integer> s2 = Set.of(4, 5, 6, 7, 8, 9);
        assertEquals(Set.of(4, 5, 6), Sets.intersection_manual(s1, s2));
    }

    @Test
    public void union_manual() {
        Set<Integer> s1 = Set.of(1, 2, 3, 4);
        Set<Integer> s2 = Set.of(4, 8, 9);
        assertEquals(Set.of(1, 2, 3, 4, 8, 9), Sets.union_manual(s1, s2));
    }

    @Test
    public void intersection() {
        Set<Integer> s1 = Set.of(1, 2, 3, 4, 5, 6);
        Set<Integer> s2 = Set.of(4, 5, 6, 7, 8, 9);
        assertEquals(Set.of(4, 5, 6), Sets.intersection(s1, s2));
    }

    @Test
    public void union() {
        Set<Integer> s1 = Set.of(1, 2, 3, 4);
        Set<Integer> s2 = Set.of(4, 8, 9);
        assertEquals(Set.of(1, 2, 3, 4, 8, 9), Sets.union(s1, s2));
    }

    @Test
    public void toList() {
        Set<Integer> s1 = Set.of(1, 2, 3, 4, 5);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), Sets.toList(s1));
    }

    @Test
    public void removeDuplicates() {
        List<Integer> s1 = Arrays.asList(1, 2, 3, 4, 5, 5, 1, 3, 4);
        assertEquals(List.of(1, 2, 3, 4, 5), Sets.removeDuplicates(s1));
    }

    @Test
    public void removeDuplicates_manual() {
        List<Integer> s1 = Arrays.asList(1, 2, 3, 4, 5, 5, 1, 3, 4);
        assertEquals(List.of(1, 2, 3, 4, 5), Sets.removeDuplicates_manual(s1));
    }

    @Test
    public void firstRecurringCharacter() {
        assertEquals("m", Sets.firstRecurringCharacter("mommy"));
        assertEquals("d", Sets.firstRecurringCharacter("daddy"));
    }

    @Test
    public void allRecurringChars() {
        assertEquals(Set.of('m', 'a'), Sets.allRecurringChars("mamma"));
        assertEquals(Set.of('d', 'e'), Sets.allRecurringChars("abcddee"));
    }

    @Test
    public void toArray() {
        Set<Integer> s = Set.of(1, 2, 3, 4, 5);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, Sets.toArray(s));
    }

    @Test
    public void getFirst() {
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(1, Sets.getFirst(t));
    }

    @Test
    public void getLast() {
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(7, Sets.getLast(t));
    }

    @Test
    public void getGreater() {
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals(6, Sets.getGreater(t, 5));
    }
}