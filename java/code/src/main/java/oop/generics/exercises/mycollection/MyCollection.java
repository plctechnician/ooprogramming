package oop.generics.exercises.mycollection;

public interface MyCollection<T> {
    void add(T o);
    void remove(T o);
    boolean contains(T o);
    int size();
}
