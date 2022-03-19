package oop.objectoriented.exercises.bankaccountv3;

public abstract class AbstractBankAccount implements BankAccount {
    String IBAN;
    double balance;

    public AbstractBankAccount(String IBAN, double balance) {
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

    public String getCountry() {
        return IBAN.substring(0, 2);
    }
}
