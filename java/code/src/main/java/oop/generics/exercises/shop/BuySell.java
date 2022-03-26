package oop.generics.exercises.shop;

import java.util.Collection;

/**
 * An interface representing an entity capable of buying and selling stuff
 *
 * @author Nicola Bicocchi
 */
public interface BuySell<T> {
    void buy(T item);
    T sell();
    void buy(Collection<? extends T> cart);
    void sell(Collection<? super T> cart, int n);
}
