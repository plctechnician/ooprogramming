package org.nbicocchi.objectoriented.bankaccount;

/**
 * Implement the classes described in UML inside the png file contained in this package.
 * Test them with the following main.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        SavingsAccount a1 = new SavingsAccount(0, 0.01);
        SavingsAccount a2 = new SavingsAccount(0, 0.02);

        a1.deposit(1000);
        a1.transfer(1000, a2);
        a2.payInterest();

        System.out.println(a1);
        System.out.println(a2);
    }
}