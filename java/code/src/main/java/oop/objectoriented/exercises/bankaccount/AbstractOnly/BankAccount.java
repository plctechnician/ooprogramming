package oop.objectoriented.exercises.bankaccount.AbstractOnly;

public abstract class BankAccount {
    String IBAN;
    double balance;

    public BankAccount(String IBAN, double balance) {
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getCountry() {
        return IBAN.substring(0, 2);
    }

    public abstract void deposit(double amount);
    public abstract double withdraw(double amount);
    public abstract double transfer(BankAccount other, double amount);
    public abstract double addAnnualInterest();
}
