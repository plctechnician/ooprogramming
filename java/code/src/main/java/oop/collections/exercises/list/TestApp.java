package oop.collections.exercises.list;

/**
 * Provide an implementation of the MyList interface and test it with the
 * main() functions reported below
 */
public class TestApp {
    public static void main(String[] args) {
        MyList l;

        l = new MyLinkedList();
        l.add("a", 0);
        l.add("b");
        l.add("c", 0);
        l.add("c", 3);
        l.remove(3);
        System.out.println("size=" + l.size());
        System.out.println(l);
    }
}
