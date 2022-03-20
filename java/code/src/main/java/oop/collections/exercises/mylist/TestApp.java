package oop.collections.exercises.mylist;

/**
 * Provide an implementation of the MyList interface
 * test it with the main() function reported below
 */
public class TestApp {
    public static void main(String[] args) {
        MyList l;

        l = new MyArrayList();
        l.add("a", 0);
        l.add("b");
        l.add("c", 0);
        l.add("c", 3);
        l.remove(3);
        System.out.println(l.size());
        System.out.println(l);
    }
}
