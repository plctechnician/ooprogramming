package oop.collections;

import oop.utils.Student;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class showing how to use binary search to search elements within a
 * collection
 *
 * @author Nicola Bicocchi
 */
public class CollectionsUtils {
    public static void main(String[] args) {
        ArrayList<Student> l = new ArrayList<>();
        l.add(new Student("Nicola", "Rossi", 28));
        l.add(new Student("Paolo", "Rossi", 25));
        l.add(new Student("Nicola", "Bianchi", 23));

        System.out.println(l);

        /*
         * Binary search return the index of the list containing the element
         */
        int index = Collections.binarySearch(l, new Student("Paolo", "Rossi", 25));
        System.out.println("Found at index: " + index);

        /*
         * Sorting using natural ordering. Comparable must be implemented within Student
         * while equals() and hashcode() must be overridden
         */
        Collections.sort(l);
        System.out.println(l);

        /*
         * Sorting using another ordering, defined within comparator
         */
        l.sort((s0, s1) -> Double.compare(s0.getAverage(), s1.getAverage()));
        System.out.println(l);

        /*
         * Sorting using another ordering, defined within comparator
         */
        l.sort((s0, s1) -> Integer.compare(s0.getLastname().length(), s1.getLastname().length()));
        System.out.println(l);
    }

}