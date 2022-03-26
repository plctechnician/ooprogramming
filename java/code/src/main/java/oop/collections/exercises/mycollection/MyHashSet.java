package oop.collections.exercises.mycollection;

public class MyHashSet extends MyAbstractSet {
    public MyHashSet() {
        super();
    }

    @Override
    public void add(Object o) {
        if (capacityRatio() > 0.6) {
            enlarge();
        }
        int bucket = getBucket(o);
        if (table[bucket] == null) {
            table[bucket] = o;
            size++;
        }
    }

    @Override
    public void remove(Object o) {
        int bucket = getBucket(o);
        table[bucket] = null;
        size--;
    }

    @Override
    public boolean contains(Object o) {
        int bucket = getBucket(o);
        return table[bucket] != null;
    }

    int getBucket(Object o) {
        int bucket = (Math.abs(o.hashCode()) % table.length);
        while (table[bucket] != null && table[bucket].hashCode() != o.hashCode()) {
            bucket = (bucket + 1) % table.length;
        }
        return bucket;
    }

    Object[] toArray() {
        Object[] tmp = new Object[size()];
        int tmpIndex = 0;
        for (Object o : table) {
            if (o != null) {
                tmp[tmpIndex++] = o;
            }
        }
        return tmp;
    }
}
