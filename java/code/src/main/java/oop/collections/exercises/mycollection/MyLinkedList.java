package oop.collections.exercises.mycollection;

/**
 * Implementation of a simplified LinkedList class
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedList extends MyAbstractList implements MyQueue {
    MyLinkedListNode head;

    public MyLinkedList() {
        super();
        head = null;
    }

    @Override
    public void add(Object o) {
        add(o, size);
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            MyLinkedListNode node = getNodeByIndex(i);
            if (node.getPayload().equals(o)) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public void add(Object o, int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            head = new MyLinkedListNode(o, head);
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode(o, current.getNext()));
        }
        size++;
    }

    MyLinkedListNode getNodeByIndex(int index) {
        MyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        if (index == 0) {
            head = head.getNext();
        } else {
            MyLinkedListNode current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public Object get(int index) {
        checkBoundaries(index, size - 1);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public Object peek() {
        return get(0);
    }

    @Override
    public Object poll() {
        Object payload = get(0);
        remove(0);
        return payload;
    }
}