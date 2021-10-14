package org.nbicocchi.generics.exercises.genericlist;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
class Node<T> {
    private T payload;
    private Node<T> next;

    public Node(T dataValue) {
        next = null;
        payload = dataValue;
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
public class MyGenericLinkedList<T> extends MyGenericAbstractList<T> {
    private Node<T> head;
    private int size;

    public MyGenericLinkedList() {
        head = null;
        size = 0;
    }

    private void addFirst(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
        } else {
            Node<T> node = new Node<>(data);
            node.setNext(head);
            head = node;
        }
        size += 1;
    }

    private boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void add(T data) {
        if (isEmpty()) {
            addFirst(data);
            return;
        }

        Node<T> temp = new Node<>(data);
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }

    @Override
    public void add(T data, int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> temp = new Node<>(data);
        Node<T> current = head;
        // crawl to the requested index or the last element in the list,
        // whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null)
                return null;
            current = current.getNext();
        }
        return current.getPayload();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
    }

    @Override
    public int size() {
        return size;
    }
}