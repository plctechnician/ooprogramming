package oop.multithreading;

import javax.swing.*;
import java.awt.*;

public class UnresponsiveUIwThread extends JFrame {
    private final JTextField tfCount;
    private final JButton btStartSingleThread;
    private final JButton btStartMultiThread;
    private final JButton btStop;
    private boolean stoppped = false;
    private int countValue = 1;

    public UnresponsiveUIwThread() {
        super("Counter");
        tfCount = new JTextField("" + countValue, 10);
        tfCount.setEditable(false);

        btStartSingleThread = new JButton("Start (1T)");
        btStartSingleThread.addActionListener(e -> {
            stoppped = false;
            updateCounter();
        });

        btStartMultiThread = new JButton("Start (2T)");
        btStartMultiThread.addActionListener(e -> {
            stoppped = false;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    updateCounter();
                }
            });
            t.start();
        });

        btStop = new JButton("Stop");
        btStop.addActionListener(e -> stoppped = true);

        JPanel p1 = new JPanel(new GridLayout(1,2));
        p1.add(new JLabel("Counter"));
        p1.add(tfCount);

        JPanel p2 = new JPanel(new GridLayout(1,3));
        p2.add(btStartSingleThread);
        p2.add(btStartMultiThread);
        p2.add(btStop);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(p1, BorderLayout.NORTH);
        mainPanel.add(p2, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(250, 90);
        setResizable(false);
        setVisible(true);
    }

    void updateCounter() {
        for (int i = 0; i < 100000; i++) {
            if (stoppped)
                break;
            tfCount.setText(Integer.valueOf(countValue).toString());
            countValue++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UnresponsiveUIwThread::new);
    }
}