package oop.generics.exercises.mycollection;

public interface MyList<T> extends MyCollection<T> {
    void add(T o, int index);
    void remove(int index);
    T get(int index);
}
