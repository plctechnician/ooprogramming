package oop.swing.producerconsumer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProducerConsumerGUI extends JFrame implements ChangeListener, ActionListener {
    public static final int SIZE = 100;
    public static final int INIT_WAIT = 100;
    public static final int MIN_WAIT = 100;
    public static final int MAX_WAIT = 1000;
    JSlider waitProducer;
    JSlider waitConsumer;
    JProgressBar progressBar;

    Queue<Integer> queue;
    Producer producer;
    Consumer consumer;
    Timer timer;

    public ProducerConsumerGUI() {
        super("Producer-Consumer");

        /* secondary panel */
        waitProducer = new JSlider(JSlider.HORIZONTAL, MIN_WAIT, MAX_WAIT, INIT_WAIT);
        waitProducer.setMajorTickSpacing(300);
        waitProducer.setPaintTicks(true);
        waitProducer.setPaintLabels(true);
        waitProducer.addChangeListener(this);

        waitConsumer = new JSlider(JSlider.HORIZONTAL, MIN_WAIT, MAX_WAIT, INIT_WAIT);
        waitConsumer.setMajorTickSpacing(300);
        waitConsumer.setPaintTicks(true);
        waitConsumer.setPaintLabels(true);
        waitConsumer.addChangeListener(this);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Producer wait period (ms)"));
        panel.add(new JLabel("Consumer wait period (ms)"));
        panel.add(waitProducer);
        panel.add(waitConsumer);

        /* main panel */
        progressBar = new JProgressBar(0, SIZE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(progressBar, BorderLayout.SOUTH);

        /* producer and consumer */
        queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < SIZE / 2; i++) queue.add(i);

        producer = new Producer(INIT_WAIT, queue, SIZE);
        consumer = new Consumer(INIT_WAIT, queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        timer = new Timer(100, this);
        timer.start();

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == waitProducer) {
            producer.wait = waitProducer.getValue();
        }

        if (e.getSource() == waitConsumer) {
            consumer.wait = waitConsumer.getValue();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            progressBar.setValue(queue.size());
        }
    }
}
