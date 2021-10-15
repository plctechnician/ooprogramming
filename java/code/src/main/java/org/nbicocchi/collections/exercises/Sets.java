package org.nbicocchi.collections.exercises;

import java.util.*;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/collection/index.php
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Sets {

    /**
     * Write a function to compare two sets and retain elements which are on both sets
     */
    public static void retain(Set<Integer> source, Set<Integer> target) {
        source.retainAll(target);
    }

    /**
     * Write a function to transform a set into a list
     */
    public static List<Integer> toList(Set<Integer> source) {
        return new ArrayList<>(source);
    }

    /**
     * Write a function to transform a set into an array
     */
    public static Integer[] toArray(Set<Integer> source) {
        Integer[] target = new Integer[source.size()];
        source.toArray(target);
        return target;
    }

    /**
     * Write a function to return the first item from a TreeSet
     */
    public static int getFirst(TreeSet<Integer> source) {
        return source.first();
    }

    /**
     * Write a function to return the last item from a TreeSet
     */
    public static int getLast(TreeSet<Integer> source) {
        return source.last();
    }

    /**
     * Write a function to get an element from a TreeSet which is strictly greater than a given element.
     */
    public static int getLast(TreeSet<Integer> source, int value) {
        return source.higher(value);
    }

    /**
     * Write a function to find in the string s, the first recurring character and return it.
     * Otherwise, return null.
     */
    public static Character firstRecurringCharacter(String s) {
        Set<Character> seenCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seenCharacters.contains(c)) {
                return c;
            } else {
                seenCharacters.add(c);
            }
        }
        return null;
    }
}