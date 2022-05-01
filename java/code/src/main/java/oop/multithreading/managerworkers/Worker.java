package oop.multithreading.managerworkers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    final PropertyChangeSupport support;
    int start, range;
    WorkerState state;

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
            PrimeSearcher ps = new PrimeSearcherFast();
            List<Integer> primes = new ArrayList<>();
            state = WorkerState.RUNNING;

            for (int i = start; i < (start + range); i++) {
                if (ps.isPrime(i)) {
                    primes.add(i);
                    support.firePropertyChange("progress", null, (100 * (i - start)) / range);
                }
                while (state == WorkerState.PAUSED) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ignored) {}
                }
            }

            state = WorkerState.COMPLETED;
            support.firePropertyChange("progress", null, 100);
            support.firePropertyChange("results", null, primes);
        });
        t.start();
    }

    public enum WorkerState {
        NEW, RUNNING, PAUSED, COMPLETED
    }
}