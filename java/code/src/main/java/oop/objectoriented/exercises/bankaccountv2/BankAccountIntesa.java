package oop.objectoriented.exercises.bankaccountv2;

public class BankAccountIntesa implements BankAccount {
    String IBAN;
    double balance;
    static final double FeeDeposit = 0.0;
    static final double FeeWithdraw = 0.0;
    static final double AnnualInterest = 0.0;

    public BankAccountIntesa(String IBAN, double balance) {
        this.IBAN = IBAN;
        this.balance = balance;
    }

    @Override
    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        double actualAmount = Math.min(balance, amount);
        balance -= actualAmount;
        balance -= actualAmount * FeeWithdraw;
        return actualAmount;
    }

    @Override
    public double transfer(BankAccount other, double amount) {
        if (!getCountry().equals(other.getCountry())) {
            return 0.0;
        }
        double actualAmount = withdraw(amount);
        other.deposit(actualAmount);
        return actualAmount;
    }

    @Override
    public double addAnnualInterest() {
        double amount = balance * AnnualInterest;
        balance += amount;
        return amount;
    }

    @Override
    public String toString() {
        return "BankAccountIntesa{" + "IBAN='" + IBAN + '\'' + ", balance=" + balance + '}';
    }
}
