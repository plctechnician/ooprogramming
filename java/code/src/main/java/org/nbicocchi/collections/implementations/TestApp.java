package org.nbicocchi.collections.implementations;

public class TestApp {
    public static void main(String[] args) {
        MyList l;

        // My LinkedList
        l = new MyLinkedList();
        l.add("alpha");
        l.add("beta");
        l.add("delta");
        l.add("omega", 0);
        l.remove(2);
        System.out.println("size=" + l.size());
        System.out.println(l);

        // MyArrayList
        l = new MyArrayList();
        l.add("alpha");
        l.add("beta");
        l.add("delta");
        l.add("omega", 0);
        l.remove(2);
        System.out.println("size=" + l.size());
        System.out.println(l);

        // MyHashMap
        MyMap m = new MyHashMap();
        m.put(11, 113);
        m.put(21, 112);
        m.put(33, 118);
        System.out.println(m);
    }
}
