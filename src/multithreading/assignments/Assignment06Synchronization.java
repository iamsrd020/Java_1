package multithreading.assignments;

/*
 * Assignment 6: Protect a shared bank account.
 *
 * Two customers want ₹700 from ₹1000. The check and subtraction must happen
 * as one protected operation; otherwise both could see the old balance.
 *
 * synchronized means only one thread at a time enters withdraw() for this
 * account. Therefore one withdrawal succeeds and the other is rejected.
 *
 * Interview point: synchronization gives mutual exclusion and visibility.
 */
public class Assignment06Synchronization {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);
        Runnable withdrawal = () -> account.withdraw(700);

        Thread customer1 = new Thread(withdrawal, "Customer 1");
        Thread customer2 = new Thread(withdrawal, "Customer 2");
        customer1.start();
        customer2.start();
        customer1.join();
        customer2.join();

        System.out.println("Final balance: ₹" + account.balance);
    }

    private static class BankAccount {
        private int balance;

        private BankAccount(int balance) {
            this.balance = balance;
        }

        private synchronized void withdraw(int amount) {
            // The balance check and update are inside one critical section.
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName()
                        + " withdrew ₹" + amount);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not withdraw ₹" + amount);
            }
        }
    }
}
