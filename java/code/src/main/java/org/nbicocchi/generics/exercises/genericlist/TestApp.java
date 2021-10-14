package org.nbicocchi.generics.exercises.genericlist;

import org.nbicocchi.utils.Student;

/**
 * Data l'implementazione semplificata di ArrayList e LinkedList (package
 * Collections->Implementations), renderle generiche (ArrayList<T>,
 * LinkedList<T>)in modo da applicarsi al caso d'uso seguente.
 *
 * @author Nicola Bicocchi
 * @see MyGenericList
 */
public class TestApp {
    public static void main(String[] args) {
        MyGenericList<Student> l;

        //l = new MyGenericArrayList<>();
        l = new MyGenericLinkedList<>();
        l.add(new Student("Padre", "Maronno", 28.4));
        l.add(new Student("Anna", "Pannocchia", 26.3));
        l.add(new Student("Maccio", "Capatonda", 29.4));
        l.add(new Student("Herbert", "Ballerina", 29.4), 1);

        l.remove(2);
        System.out.println("size=" + l.size());
        System.out.println(l);
    }
}
