package org.nbicocchi.collections;

import java.util.PriorityQueue;

/**
 * Class showing how to use basic queue methods
 *
 * @author Nicola Bicocchi
 */
public class Queue {
    public static void main(String[] args) {
        String action;
        //java.util.Queue<Integer> l = new LinkedList<>();
        java.util.Queue<Integer> l = new PriorityQueue<>();

        action = "Adding elements...";
        System.out.println(action);
        l.add(2);
        l.add(14);
        l.add(3);
        l.add(7);

        action = "Showing content...";
        System.out.println(action);
        for (int i : l) {
            System.out.println(i);
        }

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
    }
}
