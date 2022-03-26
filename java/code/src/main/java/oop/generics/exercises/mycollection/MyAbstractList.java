package oop.generics.exercises.mycollection;

public abstract class MyAbstractList<T> implements MyList<T> {
    int size;

    public MyAbstractList() {
        this.size = 0;
    }

    void checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean contains(T o) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(String.format("[%s]", get(i).toString()));
        }
        return sb.toString();
    }
}
