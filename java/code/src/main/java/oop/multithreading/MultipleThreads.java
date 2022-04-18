package oop.multithreading;

public class MultipleThreads implements Runnable {
    int n;

    public MultipleThreads(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MultipleThreads(100), "Thread-1");
        Thread t2 = new Thread(new MultipleThreads(150), "Thread-2");
        Thread t3 = new Thread(new MultipleThreads(200), "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}