package oop.generics.exercises.mycollection;

public interface MyQueue<T> extends MyCollection<T> {
    T peek();
    T poll();
}
