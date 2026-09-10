package oops;

public class BankAccount {
    // Keeps the account balance private so it cannot be changed directly.
    private double balance;

    // Creates a bank account with the given starting balance.  //This is a CONSTRUCTOR
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        }
    }

    // Adds money to the account when the amount is positive. // This is a METHOD
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Removes money only when the amount is positive and enough balance exists. //METHOD
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal denied: insufficient balance or invalid amount.");
        }
    }

    // Returns the current balance without exposing the balance field directly. //METHOD
    public double getBalance() {
        return balance;
    }
}
