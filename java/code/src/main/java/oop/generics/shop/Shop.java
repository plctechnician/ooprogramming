package oop.generics.shop;

import java.util.*;

/**
 * A shop capable of buying and selling generic stuff
 *
 * @author Nicola Bicocchi
 */
public class Shop<T> {
    final Queue<T> items;

    public Shop() {
        // a queue implementing a FIFO policy
        items = new LinkedList<>();
    }

    public void buy(T item) {
        items.add(item);
    }

    public T sell() {
        return items.poll();
    }

    public void buy(Collection<? extends T> cart) {
        items.addAll(cart);
    }

    public void sell(Collection<? super T> cart, int n) {
        for (int i = 0; i < n; i++) {
            cart.add(items.poll());
        }
    }

    public Collection getItems() {
        return items;
    }
}
