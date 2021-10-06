package org.nbicocchi.objectoriented.onlineshop;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        Customer c1 = new Customer("Mario", "Bianchi", "AA543TT");
        Customer c2 = new Customer("Lucia", "Rossi", "TT456II");
        Order o1 = new Order("101-234", 1, c1);
        Order o2 = new Order("101-876", 5, c1);
        Order o3 = new Order("101-876", 10, c2);
    }
}
