package org.nbicocchi.collections.exercises.set;

/**
 * Implementation of a fictional ArraySet
 *
 * @author Nicola Bicocchi
 */
public class MyArraySet implements MySet {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] elements;
    private int size;

    public MyArraySet() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getIndex(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void add(Object o) {
        if (size >= elements.length - 1) {
            // array resize (x2)
            Object[] tmp = new Object[elements.length * 2];
            System.arraycopy(elements, 0, tmp, 0, elements.length);
            elements = tmp;
        }
        if (!contains(o)) {
            elements[size++] = o;
        }
    }

    @Override
    public void remove(Object o) {
        int index = getIndex(o);
        if (index == -1) return;

        System.arraycopy(elements, index + 1, elements, index, size - index);
        elements[--size] = null;
    }

    @Override
    public boolean contains(Object o) {
        for (Object item : elements) {
            if (item != null && item.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(String.format("[%s]", elements[i].toString()));
        }
        return sb.toString();
    }
}
