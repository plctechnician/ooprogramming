package oop.multithreading.producerconsumer;

import java.util.Queue;

public abstract class Producer<T> implements Runnable {
    boolean running;
    int count;
    int maxitems;
    T item;
    final Queue<T> q;

    public Producer(int maxitems, T item, Queue<T> q) {
        super();
        this.running = true;
        this.count = 0;
        this.maxitems = maxitems;
        this.item = item;
        this.q = q;
    }
}
