package oop.multithreading.lockinggranularity;

public class TestApp {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        ActorA a = new ActorA(resource);
        ActorB b = new ActorB(resource);
        ActorC c = new ActorC(resource);

        a.start();
        b.start();
        c.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.running = false;
        b.running = false;
        c.running = false;
    }
}
