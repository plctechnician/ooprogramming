package oop.multithreading.bankaccount;

public class TestApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(150);
        Thread homer = new Thread(new BankUser(account), "Homer");
        Thread marge = new Thread(new BankUser(account), "Marge");
        homer.start();
        marge.start();
    }
}
