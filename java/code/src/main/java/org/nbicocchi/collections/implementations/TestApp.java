package org.nbicocchi.collections.implementations;

public class TestApp {
    public static void main(String[] args) {
        // MyList
        MyList l = new MyLinkedList();

        l.add("alpha");
        l.add("beta");
        l.add("delta");
        l.add("omega");

        System.out.println(l.get(0));
        System.out.println(l.get(1));

        // MyQueue
        System.out.println(((MyQueue) l).getFirst());
        System.out.println(((MyQueue) l).getLast());

        // MyHashMap
        MyMap m = new MyHashMap();
        m.put(11, 113);
        m.put(21, 112);
        m.put(33, 118);

        System.out.println(m.get(21));
        System.out.println(m);
    }
}
