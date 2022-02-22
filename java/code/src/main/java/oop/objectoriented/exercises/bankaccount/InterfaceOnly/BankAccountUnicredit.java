package oop.objectoriented.exercises.bankaccount.InterfaceOnly;

public class BankAccountUnicredit implements BankAccount {
    String IBAN;
    double balance;
    static final double FeeDeposit = 0.01;
    static final double FeeWithdraw = 0.01;
    static final double AnnualInterest = 0.02;

    public BankAccountUnicredit(String IBAN, double balance) {
        this.IBAN = IBAN;
        this.balance = balance;
    }

    @Override
    public String getIBAN() {
        return IBAN;
    }

    @Override
    public String getCountry() {
        return IBAN.substring(0, 2);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        balance -= amount * FeeDeposit;
    }

    @Override
    public double withdraw(double amount) {
        balance -= amount;
        balance -= amount * FeeWithdraw;
        return amount;
    }

    @Override
    public double transfer(BankAccount other, double amount) {
        withdraw(amount);
        other.deposit(amount);
        return amount;
    }

    @Override
    public double addAnnualInterest() {
        double amount = balance * AnnualInterest;
        balance += amount;
        return amount;
    }

    @Override
    public String toString() {
        return "BankAccountUnicredit{" + "IBAN='" + IBAN + '\'' + ", balance=" + balance + '}';
    }
}
