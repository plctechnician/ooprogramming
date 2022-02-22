package oop.objectoriented.exercises.bankaccount;

public abstract class AbstractBankAccount implements BankAccount {
    String IBAN;
    double balance;

    public AbstractBankAccount(String IBAN, double balance) {
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getCountry() {
        return IBAN.substring(0, 2);
    }
}
