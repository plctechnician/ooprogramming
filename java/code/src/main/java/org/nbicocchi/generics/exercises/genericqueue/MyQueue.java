package org.nbicocchi.generics.exercises.genericqueue;

public interface MyQueue<T> {
    void add(T t);

    T peek();

    T poll();
}
