package oop.objectoriented.exercises;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * Write a class named Vector representing a vector of integers with additional features.
 *
 * Supported methods:
 * void init() initialize the vector with random numbers [0, 100]
 * void sort() sorts the vector in ascending order
 * void show() shows the content of the vector
 * int search(int value) returns the index in which "value" is stored. -1 if "value" is missing.
 *
 * @author Nicola Bicocchi
 */
public class Vector {
    int[] v;

    public Vector(int[] v) {
        this.v = v;
    }

    public Vector(int capacity) {
        this.v = new int[capacity];
    }

    void init() {
        RandomGenerator rnd = RandomGeneratorFactory.getDefault().create();
        for (int i = 0; i < v.length; i++) {
            v[i] = rnd.nextInt(100);
        }
    }

    void sort() {
        boolean changed;
        for (int i = 0; i < v.length-1; i++) {
            changed = false;
            for (int j = 0; j < v.length - i - 1; j++) {
                if (v[j] > v[j + 1]) {
                    changed = true;
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;
                }
            }
            if (!changed) break;
        }
    }

    int search(int value) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == value) {
                return i;
            }
        }
        return -1;
    }

    void show() {
        for (int i = 0; i < v.length; i++) {
            System.out.printf("[%d] %d\n", i, v[i]);
        }
    }

    public static void main(String[] args) {
        int[] values = {7, 5, 34, 23, 99};
        Vector v = new Vector(values);
        v.sort();
        v.show();
        System.out.printf("%d index = %d\n", 7, v.search(7));
    }
}
