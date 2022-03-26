package oop.generics.exercises.mycollection;

/**
 * Implementation of a fictional ArraySet
 *
 * @author Nicola Bicocchi
 */
public class MyArraySet<T> extends MyAbstractSet<T> {
    public MyArraySet() {
        super();
    }

    @Override
    public void add(T o) {
        if (capacityRatio() > 0.6) {
            enlarge();
        }
        if (!contains(o)) {
            table[size++] = o;
        }
    }

    @Override
    public void remove(T o) {
        int index = getIndex(o);
        if (index == -1) return;

        System.arraycopy(table, index + 1, table, index, size - index);
        table[--size] = null;
    }

    @Override
    public boolean contains(T o) {
        int index = getIndex(o);
        return index != -1;
    }

    T[] toArray() {
        return (T[])table;
    }

    int getIndex(T o) {
        for (int i = 0; i < size; i++) {
            if (table[i].hashCode() == o.hashCode())
                return i;
        }
        return -1;
    }
}
