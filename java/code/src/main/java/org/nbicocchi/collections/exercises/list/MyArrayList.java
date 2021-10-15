package org.nbicocchi.collections.exercises.list;

/**
 * Implementation of a simplified ArrayList
 *
 * @author Nicola Bicocchi
 */
public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(Object data) {
        if (size >= elements.length - 1) {
            // array resize (x2)
            Object[] tmp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, tmp, 0, elements.length);
            elements = tmp;
        }
        elements[size++] = data;
    }

    @Override
    public void add(Object data, int index) {
        checkBoundaries(index, size);
        add(data);
        /* move array elements into memory */
        if (elements.length - 1 - index >= 0)
            System.arraycopy(elements, index, elements, index + 1, elements.length - 1 - index);
        elements[index] = data;
        elements[size] = null;
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size - 1);
        return elements[index];
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        /* move array elements into memory */
        System.arraycopy(elements, index + 1, elements, index, size - index);
        elements[--size] = null;
    }

    @Override
    public int size() {
        return size;
    }
}
