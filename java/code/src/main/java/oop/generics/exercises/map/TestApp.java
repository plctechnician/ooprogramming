package oop.generics.exercises.map;

public class TestApp {
    public static void main(String[] args) {
        MyMap<Integer, String> m = new MyHashMap<>();
        m.put(12, "Nicola");
        m.put(99, "Marzia");
        m.put(33, "Agata");
        System.out.println(m);
    }
}
