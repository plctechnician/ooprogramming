package oop.collections.exercises.mymap;

/**
 * Provide an implementation of the MyMap interface
 * test it with the main() function reported below
 */
public class TestApp {
    public static void main(String[] args) {
        MyMap m = new MyHashMap();
        m.put(11, "Nicola");
        m.put(11, "Nicola");
        m.put(21, "Marzia");
        m.put(33, "Agata");
        m.remove(21);
        System.out.println(m.contains(11));
        System.out.println(m.contains(77));
        System.out.println(m.size());
        System.out.println(m);
    }
}
