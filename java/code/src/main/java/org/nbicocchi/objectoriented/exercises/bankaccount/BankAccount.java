package org.nbicocchi.objectoriented.exercises.bankaccount;

/**
 * A bank account that users can use to deposit, withdraw, and transfer amounts.
 *
 * @author Nicola Bicocchi
 */
public abstract class BankAccount {
    double balance;

    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance = balance - amount;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public void transfer(double amount, BankAccount other) {
        withdraw(amount);
        other.deposit(amount);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}