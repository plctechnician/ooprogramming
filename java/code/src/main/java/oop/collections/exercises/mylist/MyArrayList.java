package oop.collections.exercises.mylist;

/**
 * Implementation of a simplified ArrayList
 *
 * @author Nicola Bicocchi
 */
public class MyArrayList extends MyAbstractList {
    static final int INITIAL_SIZE = 16;
    Object[] elements;
    int size;

    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public void add(Object o) {
        if (size >= elements.length - 1) {
            enlarge();
        }
        elements[size++] = o;
    }

    @Override
    public void add(Object o, int index) {
        checkBoundaries(index, size);
        add(o);
        /* move array elements into memory */
        if (elements.length - 1 - index >= 0) {
            System.arraycopy(elements, index, elements, index + 1, elements.length - 1 - index);
        }
        elements[index] = o;
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

    void enlarge() {
        Object[] tmp = new Object[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;
    }
}
