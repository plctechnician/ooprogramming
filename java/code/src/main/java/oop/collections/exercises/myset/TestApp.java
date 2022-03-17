package oop.collections.exercises.myset;

/**
 * Provide an implementation of the MySet interface
 * test it with the main() function reported below
 */
public class TestApp {
    public static void main(String[] args) {
        MyArraySet set = new MyArraySet();
        set.add("Nicola");
        set.add("Agata");
        set.add("Nicola");
        set.add("Marzia");
        set.add("Marzia");
        System.out.println(set);

        set.remove("Marzia");
        System.out.println(set);

        System.out.println(set.contains("Ugo"));
        System.out.println(set.size());

    }
}
