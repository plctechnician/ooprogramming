package oop.generics.exercises.mycollection;

/**
 * Implementation of a simplified LinkedList class
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedList<T> extends MyAbstractList<T> implements MyQueue<T> {
    MyLinkedListNode head;

    public MyLinkedList() {
        super();
        head = null;
    }

    @Override
    public void add(T o) {
        add(o, size);
    }

    @Override
    public void remove(T o) {
        for (int i = 0; i < size; i++) {
            MyLinkedListNode<T> node = getNodeByIndex(i);
            if (node.getPayload().equals(o)) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public void add(T o, int index) {
        checkBoundaries(index, size);
        if (index == 0) {
            head = new MyLinkedListNode(o, head);
        } else {
            MyLinkedListNode<T> current = getNodeByIndex(index - 1);
            current.setNext(new MyLinkedListNode<T>(o, current.getNext()));
        }
        size++;
    }

    MyLinkedListNode<T> getNodeByIndex(int index) {
        MyLinkedListNode<T> current = head;
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
            MyLinkedListNode<T> current = getNodeByIndex(index - 1);
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public T get(int index) {
        checkBoundaries(index, size - 1);
        return getNodeByIndex(index).getPayload();
    }

    @Override
    public T peek() {
        return get(0);
    }

    @Override
    public T poll() {
        T payload = get(0);
        remove(0);
        return payload;
    }
}