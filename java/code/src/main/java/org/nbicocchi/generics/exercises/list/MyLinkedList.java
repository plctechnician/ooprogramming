package org.nbicocchi.generics.exercises.list;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
class Node<T> {
    T payload;
    Node<T> next;

    public Node(T payload) {
        this.payload = payload;
        this.next = null;
    }

    public Node(T payload, Node<T> next) {
        this.payload = payload;
        this.next = next;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T dataValue) {
        payload = dataValue;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> nextValue) {
        next = nextValue;
    }
}

/**
 * Implementation of a simplified LinkedList class
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedList<T> extends MyAbstractList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void add(T data) {
        add(data, size);
    }

    @Override
    public void add(T data, int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            head = new Node<>(data, head);
        } else {
            Node<T> current = getNodeByIndex(index - 1);
            current.setNext(new Node<>(data, current.getNext()));
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkBoundaries(index, size - 1);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }
}