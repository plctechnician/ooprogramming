package org.nbicocchi.generics.exercises;

import org.nbicocchi.utils.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Scrivere un metodo che implementa una versione - generica (che può funzionare con diversi tipi) -
 * dell'algoritmo Bubble Sort.
 *
 * @author Nicola Bicocchi
 */
public class BubbleSort {
    public static void main(String[] args) {
        /* testing with doubles */
        ArrayList<Double> l = new ArrayList<>();
        l.add(2.0);
        l.add(7.0);
        l.add(1.0);
        l.add(5.0);
        bubbleSort(l);
        System.out.println(l);

        /* testing with students */
        ArrayList<Student> s = new ArrayList<>();
        s.add(new Student("Nicola", "Bicocchi", 24.6));
        s.add(new Student("Lucia", "Rossi", 28.5));
        s.add(new Student("Maccio", "Capatonda", 23.9));
        bubbleSort(s);
        System.out.println(s);
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> l) {
        boolean ordered = false;
        while (!ordered) {
            ordered = true;
            for (int i = 1; i < l.size(); i++) {
                if (l.get(i - 1).compareTo(l.get(i)) > 0) {
                    ordered = false;
                    T c = l.get(i);
                    l.set(i, l.get(i - 1));
                    l.set(i - 1, c);
                }
            }
        }
    }
}
