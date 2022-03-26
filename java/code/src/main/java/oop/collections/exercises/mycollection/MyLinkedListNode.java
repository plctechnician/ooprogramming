package oop.collections.exercises.mycollection;

/**
 * Implementation of a single node composing the linked list
 *
 * @author Nicola Bicocchi
 */
public class MyLinkedListNode {
    Object payload;
    MyLinkedListNode next;

    public MyLinkedListNode(Object payload) {
        this.payload = payload;
        this.next = null;
    }

    public MyLinkedListNode(Object payload, MyLinkedListNode next) {
        this.payload = payload;
        this.next = next;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object dataValue) {
        payload = dataValue;
    }

    public MyLinkedListNode getNext() {
        return next;
    }

    public void setNext(MyLinkedListNode nextValue) {
        next = nextValue;
    }
}
