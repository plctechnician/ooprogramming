package oop.collections.exercises.map;

public class TestApp {
    public static void main(String[] args) {
        MyMap m = new MyHashMap();
        m.put(11, "Nicola");
        m.put(21, "Marzia");
        m.put(33, "Agata");
        System.out.println(m);
    }
}
