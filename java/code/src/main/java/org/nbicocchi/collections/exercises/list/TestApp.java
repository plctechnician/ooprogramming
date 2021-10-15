package org.nbicocchi.collections.exercises.list;

public class TestApp {
    public static void main(String[] args) {
        MyList l;

        // My LinkedList
        l = new MyLinkedList();
        l.add("a", 0);
        l.add("b");
        l.add("c", 0);
        l.add("c", 3);
        l.remove(3);
        System.out.println("size=" + l.size());
        System.out.println(l);

        // MyArrayList
        l = new MyArrayList();
        l.add("a", 0);
        l.add("b");
        l.add("c", 0);
        l.add("c", 3);
        l.remove(3);
        System.out.println("size=" + l.size());
        System.out.println(l);
    }
}
