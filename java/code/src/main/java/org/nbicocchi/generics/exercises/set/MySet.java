package org.nbicocchi.generics.exercises.set;

/**
 * Interface representing basic Set operations
 *
 * @author Nicola Bicocchi
 */
public interface MySet<T> {
    void add(T o);
    void remove(T o);
    boolean contains(T o);
    int size();
}
