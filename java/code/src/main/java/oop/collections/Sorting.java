package oop.collections;

import oop.utils.Student;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class showing how to use both Comparable and Comparator interfaces
 *
 * @author Nicola Bicocchi
 */
public class Sorting {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Nicola", "Rossi", 28));
        students.add(new Student("Paolo", "Verdi", 25));
        students.add(new Student("Nicola", "Bianchi", 23));

        /* Original list */
        System.out.println(students);

        /*
         * Sorting using natural ordering. Comparable must be implemented within Student
         * while equals() and hashcode() must be overridden
         */
        Collections.sort(students);
        System.out.println(students);

        /*
         * Sorting using another ordering, defined within comparator
         */
        students.sort((s0, s1) -> Double.compare(s0.getAverage(), s1.getAverage()));
        System.out.println(students);

        /*
         * Sorting using another ordering, defined within comparator
         */
        students.sort((s0, s1) -> Integer.compare(s0.getLastname().length(), s1.getLastname().length()));
        System.out.println(students);
    }

}
