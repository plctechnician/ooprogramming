package org.nbicocchi.generics.exercises.genericlist;

/**
 * Interface representing basic List operations
 *
 * @author Nicola Bicocchi
 */
public interface MyGenericList<T> {
    void add(T data);
    void add(T data, int index);
    void remove(int index);
    T get(int index);
    int size();
}
