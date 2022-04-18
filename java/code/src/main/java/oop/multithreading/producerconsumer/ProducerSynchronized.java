package oop.multithreading.producerconsumer;

import java.util.Queue;

public class ProducerSynchronized<T> extends Producer<T> {

    public ProducerSynchronized(int maxitems, T item, Queue<T> q) {
        super(maxitems, item, q);
    }

    @Override
    public void run() {
        while (running) {
            synchronized (q) {
                if (q.size() < maxitems) {
                    q.add(item);
                    System.out.printf("Producer %s pushed %d items\n", Thread.currentThread().getName(), count);
                    count += 1;
                }
            }
        }
    }
}
