package oop.multithreading.producerconsumerUI;

import java.util.Queue;

class Producer implements Runnable {
    int wait;
    Queue<Integer> queue;
    int limit;
    public boolean running = true;

    public Producer(int wait, Queue<Integer> queue, int limit) {
        this.wait = wait;
        this.queue = queue;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e1) {
                // do nothing
            }

            if (queue.size() < limit) {
                queue.add(0);
            }
        }
    }
}