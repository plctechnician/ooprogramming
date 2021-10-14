package org.nbicocchi.collections.implementations;

public class TestApp {
    public static void main(String[] args) {
        // MyList
        MyList l = new MyLinkedList();
        //MyList l = new MyArrayList();

        l.add("alpha");
        l.add("beta");
        l.add("delta");
        l.add("omega");
        System.out.println(l);

        // MyHashMap
        MyMap m = new MyHashMap();
        m.put(11, 113);
        m.put(21, 112);
        m.put(33, 118);
        System.out.println(m);
    }
}
