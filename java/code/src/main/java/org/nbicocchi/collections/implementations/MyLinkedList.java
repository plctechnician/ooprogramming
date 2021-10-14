package org.nbicocchi.collections.implementations;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
class Node {
    Object payload;
    Node next;

    public Node(Object dataValue) {
        next = null;
        payload = dataValue;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object dataValue) {
        payload = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }
}

/**
 * Implementation of a simplified LinkedList class
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedList extends MyAbstractList {
    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    private void addFirst(Object data) {
        if (isEmpty()) {
            head = new Node(data);
        } else {
            Node node = new Node(data);
            node.setNext(head);
            head = node;
        }
        size += 1;
    }

    private boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void add(Object data) {
        if (isEmpty()) {
            addFirst(data);
            return;
        }

        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }

    @Override
    public void add(Object data, int index) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = new Node(data);
        Node current = head;
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
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node current = head;
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

        Node current = head;
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