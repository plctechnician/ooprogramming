package org.nbicocchi.generics.exercises.genericqueue;

import java.util.LinkedList;

public abstract class MyAbstractQueue<T> implements MyQueue<T> {
    LinkedList<T> elements;

    public MyAbstractQueue() {
        elements = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        elements.addFirst(t);
    }
}
