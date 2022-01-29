package oop.swing.producerconsumer;

import java.util.Queue;

class Consumer implements Runnable {
    int wait;
    boolean running = true;
    Queue<Integer> queue;

    public Consumer(int wait, Queue<Integer> queue) {
        this.wait = wait;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            if (!queue.isEmpty()) {
                queue.poll();
            }
        }
    }
}
