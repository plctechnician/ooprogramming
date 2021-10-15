package org.nbicocchi.collections.exercises.set;

/**
 * Interface representing basic Set operations
 *
 * @author Nicola Bicocchi
 */
public interface MySet {
    void add(Object o);
    void remove(Object o);
    boolean contains(Object o);
    int size();
}
