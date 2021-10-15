package org.nbicocchi.generics.exercises.map;

import java.util.Objects;

/**
 * Implementation of a simplified HashMap
 *
 * @author Nicola Bicocchi
 */
class MyHashMap_HashEntry<K,V> {
    final K key;
    final V value;

    MyHashMap_HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyHashMap_HashEntry)) return false;
        MyHashMap_HashEntry<?, ?> that = (MyHashMap_HashEntry<?, ?>) o;
        return Objects.equals(getKey(), that.getKey()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}

public class MyHashMap<K,V> implements MyMap<K,V> {
    private final static int TABLE_SIZE = 8;
    MyHashMap_HashEntry<K,V>[] table;

    public MyHashMap() {
        table = new MyHashMap_HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public V get(K key) {
        V value;
        int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null) {
            value = null;
        } else {
            value = table[hash].getValue();
        }
        return value;
    }

    public void put(K key, V value) {
        int hash = (key.hashCode() % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new MyHashMap_HashEntry<>(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TABLE_SIZE; i++) {
            try {
                K key = table[i].getKey();
                V value = table[i].getValue();
                int hash = (key.hashCode() % TABLE_SIZE);
                sb.append("bucket ").append(i).append(" --> (").append(key).append(", ").append(value).append(")");
            } catch (NullPointerException e) {
                sb.append("bucket ").append(i).append(" --> null");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}