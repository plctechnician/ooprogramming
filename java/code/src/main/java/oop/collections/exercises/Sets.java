package oop.collections.exercises;

import java.util.*;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/collection/index.php
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Sets {

    /**
     * Write a function returning the intersection of two given sets without using library functions
     */
    public static Set<Integer> intersection_manual(Set<Integer> source, Set<Integer> target) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : source) {
            if (target.contains(i)) {
                tmp.add(i);
            }
        }
        return tmp;
    }

    /**
     * Write a function returning the union of two given sets without using library functions
     */
    public static Set<Integer> union_manual(Set<Integer> source, Set<Integer> target) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : source) {
            tmp.add(i);
        }
        for (int i : target) {
            tmp.add(i);
        }
        return tmp;
    }

    /**
     * Write a function returning the intersection of two given sets (see retainAll())
     */
    public static Set<Integer> intersection(Set<Integer> source, Set<Integer> target) {
        Set<Integer> tmp = new HashSet<>(source);
        tmp.retainAll(target);
        return tmp;
    }

    /**
     * Write a function returning the union of two given sets (see addAll())
     */
    public static Set<Integer> union(Set<Integer> source, Set<Integer> target) {
        Set<Integer> tmp = new HashSet<>(source);
        tmp.addAll(target);
        return tmp;
    }

    /**
     * Write a function to transform a set into a list without duplicates
     * Remember collections can be created from another collection!
     */
    public static List<Integer> toList(Set<Integer> source) {

        return new ArrayList<>(source);
    }

    /**
     * Write a function to remove duplicates from a list
     * Remember collections can be created from another collection!
     */
    public static List<Integer> removeDuplicates(List<Integer> l) {

        return new ArrayList<>(new HashSet<>(l));
    }

    /**
     * Write a function to remove duplicates from a list without using the constructors trick seen above
     */
    public static List<Integer> removeDuplicates_manual(List<Integer> l) {
        Set<Integer> seen = new HashSet<Integer>();
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i : l) {
            if (!seen.contains(i)) {
                seen.add(i);
                tmp.add(i);
            }
        }
        return tmp;
    }

    /**
     * Write a function accepting a string s, and returning the first recurring character.
     * Otherwise, return null. For example firstRecurringCharacter("abaco") returns a.
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
     * Write a function accepting a string s, and returning a set comprising all returning charachters.
     * For example allRecurringChars("mamma") returns [m, a].
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
    public static int getGreater(TreeSet<Integer> source, int value) {

        return source.higher(value);
    }
}