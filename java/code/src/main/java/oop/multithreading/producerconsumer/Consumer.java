package oop.multithreading.producerconsumer;

import java.util.Queue;

public abstract class Consumer<T> implements Runnable {
    public boolean running;
    int count;
    final Queue<T> q;

    public Consumer(Queue<T> q) {
        super();
        this.running = true;
        this.count = 0;
        this.q = q;
    }
}
