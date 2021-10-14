package org.nbicocchi.generics.exercises.genericlist;

/**
 * Simplified implementation of a generic ArrayList
 *
 * @author Nicola Bicocchi
 */
public class GenericArrayList<T> extends GenericAbstractList<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private Object[] elements;

    public GenericArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T data) {
        // we re-allocate before complete fullness
        if (size >= elements.length - 1) {
            // buffer re-allocation
            Object[] tmp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, tmp, 0, elements.length);
            elements = tmp;
        }
        elements[size] = data;
        size++;
    }

    @Override
    public void add(T data, int index) {
        add(data);
        /* move array elements into memory */
        if (elements.length - 1 - index >= 0)
            System.arraycopy(elements, index, elements, index + 1, elements.length - 1 - index);
        elements[index] = data;
        elements[size] = null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size())
            return null;
        return (T) elements[index];
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size())
            return false;
        /* move array elements into memory */
        if (size - index >= 0) System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
        elements[size] = null;
        return true;
    }

    @Override
    public int size() {
        return size;
    }
}
