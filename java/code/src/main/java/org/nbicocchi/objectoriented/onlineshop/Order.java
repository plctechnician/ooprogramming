package org.nbicocchi.objectoriented.onlineshop;

public class Order {
    String itemID;
    int quantity;
    Customer customer;

    public Order(String itemID, int quantity, Customer customer) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemID='" + itemID + '\'' +
                ", quantity='" + quantity + '\'' +
                ", customer=" + customer +
                '}';
    }
}
