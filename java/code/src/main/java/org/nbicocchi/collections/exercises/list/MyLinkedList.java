package org.nbicocchi.collections.exercises.list;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
class Node {
    Object payload;
    Node next;

    public Node(Object payload) {
        this.payload = payload;
        this.next = null;
    }

    public Node(Object payload, Node next) {
        this.payload = payload;
        this.next = next;
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

    private Node getNodeByIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void add(Object o) {
        add(o, size);
    }

    @Override
    public void add(Object o, int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            head = new Node(o, head);
        } else {
            Node current = getNodeByIndex(index - 1);
            current.setNext(new Node(o, current.getNext()));
        }
        size++;
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size - 1);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        if (index == 0) {
            head = head.getNext();
        } else {
            Node current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }
}