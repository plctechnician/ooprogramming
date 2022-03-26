package oop.generics.exercises.mycollection;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedListNode<T> {
    T payload;
    MyLinkedListNode next;

    public MyLinkedListNode(T payload) {
        this.payload = payload;
        this.next = null;
    }

    public MyLinkedListNode(T payload, MyLinkedListNode next) {
        this.payload = payload;
        this.next = next;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode nextValue) {
        next = nextValue;
    }
}
