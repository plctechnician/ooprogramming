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
     * Write a function to fill a generic list with the same object (without using java.util.Collections methods)
     */
    public static <T> void fill(List<? super T> list, T obj) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, obj);
        }
    }

    /**
     * Write a function to copy a generic list inside another generic list (without using java.util.Collections methods)
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
     * Write a function to swap 2 elements within a generic list (without using java.util.Collections methods)
     */
    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    /**
     * Write a function to shuffle a generic list (without using java.util.Collections methods)
     */
    public static void shuffle(List<?> list) {
        Random rnd = new Random();
        for (int i = 0; i < list.size(); i++) {
            swap(list, i, rnd.nextInt(list.size()));
        }
    }

    /**
     * Write a function to reverse a generic list (without using java.util.Collections methods)
     */
    public static void reverse(List<?> list) {
        int size = list.size();
        for (int i = 0; i < Math.floor((double)size / 2); i++) {
            swap(list, i, size - i - 1);
        }
    }

    /**
     * Write a function to find the minimum within a generic Collection of comparable objects (without using java.util.Collections methods)
     * Note well: The Collection interface does not support indexing (e.g., get(index)...)!
     */
    public static <T extends Comparable<? super T>> T min(Collection<T> list) {
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
     * Write a function to find the maximum within a generic List of Comparable objects (without using java.util.Collections methods)
     */
    public static <T extends Comparable<? super T>> T max(List<T> list) {
        T candidate = list.get(0);
        for (T next : list) {
            if (candidate.compareTo(next) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    /**
     * Write a function to find the maximum within a generic List of objects using an external Comparator (without
     * using java.util.Collections methods)
     */
    public static <T> T max(List<T> list, Comparator<? super T> cmp) {
        T candidate = list.get(0);
        for (T next : list) {
            if (cmp.compare(candidate, next) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    /**
     * Write a function to sort a generic list using Bubble Sort (without using java.util.Collections methods)
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
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

    /**
     * Write a function returning a sorted copy of a generic array using Bubble Sort (without using java.util.Arrays
     * methods)
     */
    public static <T extends Comparable<? super T>> T[] sort(T[] src) {
        int size = src.length;
        // shallow copy! could have issues!
        T[] dst = src.clone();

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int j = 0; j < size - 1; j++) {
                if (dst[j].compareTo(dst[j + 1]) > 0) {
                    T tmp = dst[j];
                    dst[j] = dst[j + 1];
                    dst[j + 1] = tmp;
                    changed = true;
                }
            }
        }
        return dst;
    }

    /**
     * Write a function returning the floating point division of any two numbers regardless of their type
     * Note: Use the java.lang.Number class
     */
    public static <T extends Number> double divide(T a, T b) {
        return a.doubleValue() / b.doubleValue();
    }

    /**
     * Write a function counting all occurrences of T within a T[]. The function should be capable of counting null
     * values as well.
     */
    public static <T> int countOccurrences(T[] src, T item) {
        int count = 0;
        if (item == null) {
            for (T listItem : src)
                if (listItem == null)
                    count++;
        }
        else {
            for (T listItem : src)
                if (item.equals(listItem))
                    count++;
        }
        return count;
    }
}
