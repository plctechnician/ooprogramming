package org.nbicocchi.collections.implementations;

/**
 * Implementation of a simplified ArrayList class
 *
 * @author Nicola Bicocchi
 */
public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 8;
    private int size;
    private Object[] elements;

    public MyArrayList() {
        // allocate default initial capacity
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Object data) {
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
    public void add(Object data, int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        add(data);
        /* move array elements into memory */
        if (elements.length - 1 - index >= 0)
            System.arraycopy(elements, index, elements, index + 1, elements.length - 1 - index);
        elements[index] = data;
        elements[size] = null;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        return elements[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        }
        /* move array elements into memory */
        if (size - index >= 0) System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
        elements[size] = null;
    }

    @Override
    public int size() {
        return size;
    }
}
