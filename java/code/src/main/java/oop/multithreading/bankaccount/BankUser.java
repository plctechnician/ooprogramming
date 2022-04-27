package oop.multithreading.bankaccount;

import java.util.Random;
import java.util.random.RandomGenerator;

public class BankUser implements Runnable {
    private final BankAccount account;
    private final RandomGenerator rnd;

    public BankUser(BankAccount account) {
        this.account = account;
        rnd = new Random();
    }

    @Override
    /*
     * Remove synchronized (account) to observe eventual race conditions. They might
     * show up immediately or after several runs. Because of these unpredictable
     * behaviors, multi-threaded programs are often difficult to debug!
     */
    public void run() {
        while (true) {
            synchronized (account) {
                int amount = rnd.nextInt(100);

                if (account.getBalance() < amount) {
                    System.out.printf("%s quitting [balance=%d, amount=%d]\n", Thread.currentThread().getName(),
                            account.getBalance(), amount);
                    break;
                }

                System.out.printf("%s is going to withdraw [balance=%d, amount=%d]\n", Thread.currentThread().getName(),
                        account.getBalance(), amount);

                account.withdraw(amount);

                System.out.printf("%s completed withdraw [balance=%d]\n", Thread.currentThread().getName(),
                        account.getBalance());

                if (account.getBalance() < 0) {
                    System.out.printf("%s DOH!! [balance=%d, amount=%d]\n", Thread.currentThread().getName(),
                            account.getBalance(), amount);
                    break;
                }
                Thread.yield();
            }
        }
    }
}
