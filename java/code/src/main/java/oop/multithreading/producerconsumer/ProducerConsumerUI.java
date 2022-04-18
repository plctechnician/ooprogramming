package oop.multithreading.producerconsumer;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProducerConsumerUI extends JFrame {
    private JPanel mainPanel;
    private JButton btSync;
    private JButton btSyncWN;
    private JButton btLinkedQueue;
    private JLabel lbSync;
    private JLabel lbSyncWN;
    private JLabel lbLinkedQueue;

    public ProducerConsumerUI() throws HeadlessException {
        super("Producer-Consumer Benchmark");

        btSync.addActionListener(e -> {
            Queue<Integer> queue = new LinkedList<>();
            Producer<Integer> producer = new ProducerSynchronized<>(4, 1, queue);
            Consumer<Integer> consumer = new ConsumerSynchcronized<>(queue);
            runTest(producer, consumer);
            lbSync.setText(consumer.count + " items / sec");
        });
        btSyncWN.addActionListener(e -> {
            Queue<Integer> queue = new LinkedList<>();
            Producer<Integer> producer = new ProducerSynchronizedWaitNotify<>(4, 1, queue);
            Consumer<Integer> consumer = new ConsumerSynchcronizedWaitNotify<>(queue);
            runTest(producer, consumer);
            lbSyncWN.setText(consumer.count + " items / sec");
        });
        btLinkedQueue.addActionListener(e -> {
            Queue<Integer> queue = new ConcurrentLinkedQueue<>();
            Producer<Integer> producer = new ProducerLinkedQueue<>(4, 1, queue);
            Consumer<Integer> consumer = new ConsumerLinkedQueue<>(queue);
            runTest(producer, consumer);
            lbLinkedQueue.setText(consumer.count + " items / sec");
        });

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    void runTest(Producer<Integer> p, Consumer<Integer> c) {
        Thread t0 = new Thread(p);
        Thread t1 = new Thread(c);
        t0.start();
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        p.running = false;
        c.running = false;
        try {
            t0.join();
            t1.join();
        } catch (InterruptedException ignored) {
        }
    }
}
