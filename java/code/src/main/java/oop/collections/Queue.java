package oop.collections;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Class showing how to use basic queue methods
 *
 * @author Nicola Bicocchi
 */
public class Queue {
    public static void main(String[] args) {
        String action;
        //java.util.Queue<Integer> l = new LinkedList<>(List.of(21, 14, 7, 99));
        java.util.Queue<Integer> l = new PriorityQueue<>(List.of(21, 14, 7, 99));

        action = "Peek element...";
        System.out.println(action);
        System.out.println(l.peek());

        action = "Peek element...";
        System.out.println(action);
        System.out.println(l.peek());

        action = "Poll element...";
        System.out.println(action);
        System.out.println(l.poll());

        action = "Showing content...";
        System.out.println(action);
        for (int i : l) {
            System.out.println(i);
        }

        action = "Showing content (iterator)...";
        System.out.println(action);
        for (Iterator<Integer> i = l.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }
}
