package oop.collections.exercises.mycollection;

public abstract class MyAbstractSet implements MySet {
    final static int INITIAL_SIZE = 8;
    Object[] table;
    int size = 0;

    public MyAbstractSet() {
        this.table = new Object[INITIAL_SIZE];
    }

    void enlarge() {
        Object[] tmp = new Object[table.length * 2];
        System.arraycopy(table, 0, tmp, 0, table.length);
        table = tmp;
    }

    double capacityRatio() {
        return size / (double)table.length;
    }

    public String showBuckets() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append(String.format("[bucket %d] -> null\n", i));
            } else {
                sb.append(String.format("[bucket %d] -> %s\n", i, table[i]));
            }
        }
        return sb.toString();
    }

    abstract Object[] toArray();

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Object[] tmp = toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(String.format("[%s]", tmp[i]));
        }
        return sb.toString();
    }
}
