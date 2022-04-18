package oop.multithreading;

public class StartStopRunnable implements Runnable {
    public boolean running = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        while (running) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " terminated");
    }

    public static void main(String[] args) {
        StartStopRunnable r01 = new StartStopRunnable();
        StartStopRunnable r02 = new StartStopRunnable();

        Thread a = new Thread(r01, "Homer");
        Thread b = new Thread(r02, "Marge");

        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);

        a.start();
        b.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {

        }

        // Graceful shutdown!
        r01.running = false;
        r02.running = false;

        // Ungraceful shutdown!
        // a.interrupt();
        // b.interrupt();
    }
}
