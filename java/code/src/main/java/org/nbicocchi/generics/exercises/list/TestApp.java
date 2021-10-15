package org.nbicocchi.generics.exercises.list;

public class TestApp {
    public static void main(String[] args) {
        MyList<String> l = new MyLinkedList<>();
        l.add("a", 0);
        l.add("b");
        l.add("c", 0);
        l.add("c", 3);
        l.remove(3);
        System.out.println("size=" + l.size());
        System.out.println(l);
    }
}
