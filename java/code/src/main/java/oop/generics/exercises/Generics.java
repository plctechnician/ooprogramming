package oop.generics.exercises;

import java.util.*;

/**
 * You can find many more here:
 *
 *
 * Preferences -> Editor -> General -> Code folding -> One-line methods (uncheck)
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Generics {
    /**
     * Write a function to fill a generic list with the same object
     */
    public static <T> void fill(List<? super T> list, T obj) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, obj);
        }
    }

    /**
     * Write a function to copy a generic list inside another generic list
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        if (src.size() != dest.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        for (int i = 0; i < src.size(); i++) {
            dest.set(i, src.get(i));
        }
    }

    /**
     * Write a function to swap 2 elements within a generic list
     */
    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    /**
     * Write a function to shuffle a generic list
     */
    public static void shuffle(List<?> list) {
        Random rnd = new Random();
        for (int i = 0; i < list.size(); i++) {
            swap(list, i, rnd.nextInt(list.size()));
        }
    }

    /**
     * Write a function to reverse a generic list
     */
    public static void reverse(List<?> list) {
        int size = list.size();
        for (int i = 0; i < Math.floor(size / 2); i++) {
            swap(list, i, size - i - 1);
        }
    }

    /**
     * Write a function to find the minimum within a generic Collection of comparable objects
     * Note well: The Collection interface does not support indexing (e.g., get(index)...)!
     */
    public static <T extends Comparable<T>> T min(Collection<T> list) {
        Iterator<T> i = list.iterator();
        T candidate = i.next();
        while (i.hasNext()) {
            T next = i.next();
            if (candidate.compareTo(next) > 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    /**
     * Write a function to find the maximum within a generic List of comparable objects
     */
    public static <T extends Comparable<T>> T max(List<T> list) {
        T candidate = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            T next = list.get(i);
            if (candidate.compareTo(next) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    /**
     * Write a function to sort a generic list using Bubble Sort
     */
    public static <T extends Comparable<T>> void sort(List<T> list) {
        int size = list.size();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int j = 0; j < size - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                    changed = true;
                }
            }
        }
    }
}
