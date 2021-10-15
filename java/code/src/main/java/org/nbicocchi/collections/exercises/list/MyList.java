package org.nbicocchi.collections.exercises.list;

/**
 * Interface representing basic List operations
 *
 * @author Nicola Bicocchi
 */
public interface MyList {
    void add(Object o);
    void add(Object o, int index);
    void remove(int index);
    Object get(int index);
    int size();
}
