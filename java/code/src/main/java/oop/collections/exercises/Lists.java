package oop.collections.exercises;


import java.util.*;

/**
 * You can find many more here:
 * https://www.w3resource.com/java-exercises/collection/index.php
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Lists {

    /**
     * Write a function to insert an element into a list at the beginning
     */
    public static void insertFirst(List<Integer> list, int value) {
        list.add(0, value);
    }

    /**
     * Write a function to insert an element into a list at the end
     */
    public static void insertLast(List<Integer> list, int value) {
        list.add(value);
    }

    /**
     * Write a function to replace the 3rd element with a given value
     */
    public static void replace(List<Integer> list, int value) {
        list.set(2, value);
    }

    /**
     * Write a function to remove the 3rd element from a list
     */
    public static void removeThird(List<Integer> list) {
        list.remove(2);
    }

    /**
     * Write a function to verify if a list contains a certain value
     */
    public static boolean contains(List<Integer> list, int value) {
        return list.contains(value);
    }

    /**
     * Write a function to copy a list into another list
     */
    public static void copy(List<Integer> source, List<Integer> target) {
        Collections.copy(target, source);
    }

    /**
     * Write a function to reverse the elements of a list
     */
    public static void reverse(List<Integer> list) {
        Collections.reverse(list);
    }

    /**
     * Write a function to iterate and print all elements of a list
     */
    public static void iterate(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    /**
     * Write a function to iterate and print all elements of an ArrayList in reverse order
     */
    public static void iterateReverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Write a function to iterate and print all elements of a LinkedList in reverse order
     */
    public static void iterateReverse(LinkedList<Integer> list) {
        for (Iterator<Integer> i = list.descendingIterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }

    /**
     * Write a function to insert the same element both at the beginning
     * and the end of the same LinkedList
     */
    public static void insertBeginningEnd(LinkedList<Integer> list, int value) {
        list.addFirst(value);
        list.addLast(value);
    }
}
