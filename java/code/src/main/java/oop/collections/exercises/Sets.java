package oop.collections.exercises;

import java.util.*;
/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/collection/index.php
 *
 * Preferences -> Editor -> General -> Code folding -> One-line methods (uncheck)
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Sets {
    /**
     * Write a function returning the intersection of two given sets (without using library functions)
     */
    public static Set<Integer> intersection_manual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : first) {
            if (second.contains(i)) {
                tmp.add(i);
            }
        }
        return tmp;
    }

    /**
     * Write a function returning the union of two given sets (without using library functions)
     */
    public static Set<Integer> union_manual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : first) {
            tmp.add(i);
        }
        for (int i : second) {
            tmp.add(i);
        }
        return tmp;
    }

    /**
     * Write a function returning the intersection of two given sets (see retainAll())
     */
    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> tmp = new HashSet<>(first);
        tmp.retainAll(second);
        return tmp;
    }

    /**
     * Write a function returning the union of two given sets (see addAll())
     */
    public static Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> tmp = new HashSet<>(first);
        tmp.addAll(second);
        return tmp;
    }

    /**
     * Write a function to transform a set into a list without duplicates
     * Note well: collections can be created from another collection!
     */
    public static List<Integer> toList(Set<Integer> source) {
        return new ArrayList<>(source);
    }

    /**
     * Write a function to remove duplicates from a list
     * Note well: collections can be created from another collection!
     */
    public static List<Integer> removeDuplicates(List<Integer> l) {
        return new ArrayList<>(new HashSet<>(l));
    }

    /**
     * Write a function to remove duplicates from a list without using the constructors trick seen above
     */
    public static List<Integer> removeDuplicates_manual(List<Integer> l) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i : l) {
            if (!seen.contains(i)) {
                seen.add(i);
                tmp.add(i);
            }
        }
        return tmp;
    }

    /**
     * Write a function accepting a string s
     * returning the first recurring character
     * For example firstRecurringCharacter("abaco") -> a.
     */
    public static String firstRecurringCharacter(String s) {
        Set<Character> seenCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seenCharacters.contains(c)) {
                return Character.toString(c);
            } else {
                seenCharacters.add(c);
            }
        }
        return null;
    }

    /**
     * Write a function accepting a string s, and returning a set comprising all recurring characters.
     * For example allRecurringChars("mamma") -> [m, a].
     */
    public static Set<Character> allRecurringChars(String s) {
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
            } else {
                duplicates.add(c);
            }
        }
        return duplicates;
    }

    /**
     * Write a function to transform a set into an array
     */
    public static Integer[] toArray(Set<Integer> source) {
        return source.toArray(new Integer[]{});
    }

    /**
     * Write a function to return the first item from a TreeSet
     * Note well: use TreeSet specific methods
     */
    public static int getFirst(TreeSet<Integer> source) {
        return source.first();
    }

    /**
     * Write a function to return the last item from a TreeSet
     * Note well: use TreeSet specific methods
     */
    public static int getLast(TreeSet<Integer> source) {
        return source.last();
    }

    /**
     * Write a function to get an element from a TreeSet which is strictly greater than a given element.
     * Note well: use TreeSet specific methods
     */
    public static int getGreater(TreeSet<Integer> source, int value) {
        return source.higher(value);
    }
}