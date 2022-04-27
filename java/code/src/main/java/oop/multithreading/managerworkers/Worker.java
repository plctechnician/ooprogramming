package oop.multithreading.managerworkers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    public enum WorkerState {
        NEW, RUNNING, PAUSED, COMPLETED
    }

    int start, range;
    WorkerState state;
    final PropertyChangeSupport support;

    public Worker(int start, int range) {
        this.start = start;
        this.range = range;
        state = WorkerState.NEW;
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public WorkerState getState() {
        return state;
    }

    public void setState(WorkerState state) {
        this.state = state;
    }

    public void search() {
        Thread t = new Thread(() -> {
            state = WorkerState.RUNNING;
            List<Integer> results = new ArrayList<>();
            for (int i = start; i < (start + range); i++) {
                if (isPrime(i)) {
                    results.add(i);
                }

                // observability (25 times each range)
                if (i % (range / 25) == 0) {
                    support.firePropertyChange("progress", null, (100*(i-start))/range);
                }

                // pause
                while (state == WorkerState.PAUSED) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ignored) {}
                }
            }
            state = WorkerState.COMPLETED;
            support.firePropertyChange("results", null, results);
        });
        t.start();
    }

    boolean isPrime(int n) {
        if (n == 1) {
            return true;
        }
        int i = 2;
        for (; n % i != 0; i++);
        return i == n;
    }
}