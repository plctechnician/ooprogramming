package oop.generics.exercises.list;

/**
 * Interface representing basic List operations
 *
 * @author Nicola Bicocchi
 */
public interface MyList<T> {
    void add(T data);
    void add(T data, int index);
    void remove(int index);
    T get(int index);
    int size();
}
