package org.nbicocchi.generics.exercises.genericqueue;

/**
 * Costruire, fruttando LinkedList, una classe FIFO e una classe LIFO in grado
 * di manipolare oggetti generici. FIFO e LIFO sono code (implementano
 * l'interfaccia MyQueue) ed utilizzano al loro interno le politiche Fist In
 * First Out e Last in First Out rispettivamente.
 * <p>
 * Le due code ritornano i loro oggetti interni attraverso due metodi: (1)
 * peek() che ritorna l'ultimo elemento senza eliminarlo dalla lista e (2) poll() che
 * ritorna l'ultimo elemento eliminandolo dalla lista. Gli alement sono invece
 * inseriti utilizzando il metodo add().
 *
 * @author Nicola Bicocchi
 * @see MyQueue
 */
public class TestApp {
    public static void main(String[] x) {
        MyQueue<String> q1 = new LIFO<>();

        q1.add("Car");
        q1.add("Ball");
        q1.add("Spoon");

        System.out.println(q1.peek());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
    }

}
