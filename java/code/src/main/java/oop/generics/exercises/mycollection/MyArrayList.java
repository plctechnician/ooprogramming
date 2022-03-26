package oop.generics.exercises.mycollection;

/**
 * Implementation of a simplified ArrayList
 *
 * @author Nicola Bicocchi
 */
public class MyArrayList<T> extends MyAbstractList<T> {
    static final int INITIAL_SIZE = 16;
    Object[] elements;

    public MyArrayList() {
        super();
        elements = new Object[INITIAL_SIZE];
    }

    @Override
    public void add(T o, int index) {
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
    public void add(T o) {
        if (size >= elements.length - 1) {
            enlarge();
        }
        elements[size++] = o;
    }

    void enlarge() {
        Object[] tmp = new Object[elements.length * 2];
        System.arraycopy(elements, 0, tmp, 0, elements.length);
        elements = tmp;
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        /* move array elements into memory */
        System.arraycopy(elements, index + 1, elements, index, size - index);
        elements[--size] = null;
    }

    @Override
    public T get(int index) {
        checkBoundaries(index, size - 1);
        return (T)elements[index];
    }
}
