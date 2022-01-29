package oop.generics.exercises.map;

public interface MyMap<K, V> {
    V get(K key);
    void put(K key, V value);
}
