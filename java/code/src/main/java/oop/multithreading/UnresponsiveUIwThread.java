package oop.multithreading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnresponsiveUIwThread extends JFrame {
    private final JTextField tfCount;
    private final JButton btnStart;
    private final JButton btnStop;
    private boolean stoppped = false;
    private int countValue = 1;

    public UnresponsiveUIwThread() {
        super("Counter");
        tfCount = new JTextField("" + countValue, 10);
        tfCount.setEditable(false);
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stoppped = false;

                /* Execute the updateCounter() method in another thread. */
                //Thread t = new Thread(this::updateCounter);
                //t.start();

                 /* Execute the updateCounter() method in main thread. */
                updateCounter();
            }
        });

        btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stoppped = true;
            }
        });

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        mainPanel.add(new JLabel("Counter"));
        mainPanel.add(tfCount);
        mainPanel.add(btnStart);
        mainPanel.add(btnStop);
        add(mainPanel);

        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(250, 120);
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
        EventQueue.invokeLater(UnresponsiveUIwThread::new);
    }
}