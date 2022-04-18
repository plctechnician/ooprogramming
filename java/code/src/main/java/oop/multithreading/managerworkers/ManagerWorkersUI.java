package oop.multithreading.managerworkers;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ManagerWorkersUI extends JFrame implements PropertyChangeListener {
    private JPanel mainPanel;
    private JButton btStart;
    private JButton btStop;
    private JProgressBar pbThread0;
    private JProgressBar pbThread1;
    private JProgressBar pbThread2;
    private JProgressBar pbThread3;
    private JTextArea taLog;

    List<Worker> workers;
    Properties settings;

    public ManagerWorkersUI() throws HeadlessException {
        super("Manager-Workers");

        initSettings();
        initWorkers();

        btStart.addActionListener(e -> {
            clearGUI();
            initSettings();
            initWorkers();
            runInactiveWorkers();
        });

        btStop.addActionListener(e -> {
            if (settings.getProperty("paused").equals("false")) {
                pauseWorkers();
                btStop.setText("Resume");
                settings.setProperty("paused", "true");
            } else if (settings.getProperty("paused").equals("true")) {
                resumeWorkers();
                btStop.setText("Pause");
                settings.setProperty("paused", "false");
            }
        });

        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 400);
        setResizable(false);
        setVisible(true);
    }

    void clearGUI() {
        pbThread0.setValue(0);
        pbThread1.setValue(0);
        pbThread2.setValue(0);
        pbThread3.setValue(0);
        btStop.setText("Start");
        btStop.setText("Pause");
        taLog.setText("");
    }

    void initSettings() {
        settings = new Properties();
        settings.setProperty("blocksize", "10000");
        settings.setProperty("workerCount", "0");
        settings.setProperty("paused", "false");
    }

    void initWorkers() {
        workers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            workers.add(nextWorker());
        }
    }

    Worker nextWorker() {
        int workerCount = Integer.parseInt(settings.getProperty("workerCount"));
        int blocksize = Integer.parseInt(settings.getProperty("blocksize"));

        Worker worker = new Worker(workerCount * blocksize, (workerCount + 1) * (blocksize) - 1);
        worker.addPropertyChangeListener(this);

        settings.setProperty("workerCount", Integer.toString(workerCount + 1));
        return worker;
    }

    void replaceCompletedWorkers() {
        for (int i = 0; i < 4; i++) {
            if (workers.get(i).getState() == Worker.WorkerState.COMPLETED) {
                workers.set(i, nextWorker());
            }
        }
    }

    void runInactiveWorkers() {
        for (int i = 0; i < 4; i++) {
            if (workers.get(i).getState() == Worker.WorkerState.NEW) {
                workers.get(i).search();
            }
        }
    }

    void pauseWorkers() {
        for (int i = 0; i < 4; i++) {
            if (workers.get(i).getState() == Worker.WorkerState.RUNNING) {
                workers.get(i).setState(Worker.WorkerState.PAUSED);
            }
        }
    }

    void resumeWorkers() {
        for (int i = 0; i < 4; i++) {
            if (workers.get(i).getState() == Worker.WorkerState.PAUSED) {
                workers.get(i).setState(Worker.WorkerState.RUNNING);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("progress")) {
            if (evt.getSource() == workers.get(0)) {
                pbThread0.setValue((Integer) evt.getNewValue());
            } else if (evt.getSource() == workers.get(1)) {
                pbThread1.setValue((Integer) evt.getNewValue());
            } else if (evt.getSource() == workers.get(2)) {
                pbThread2.setValue((Integer) evt.getNewValue());
            } else if (evt.getSource() == workers.get(3)) {
                pbThread3.setValue((Integer) evt.getNewValue());
            }
        }
        if (evt.getPropertyName().equals("results")) {
            for (int i : (List<Integer>)evt.getNewValue()) {
                taLog.append(String.format("%d,", i));
            }
            replaceCompletedWorkers();
            runInactiveWorkers();
        }
    }
}

