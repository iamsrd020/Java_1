package oops;

public class BankAccountDemo {
    // Program execution starts from the main method.
    public static void main(String[] args) {
        // Creates a BankAccount object with an initial balance of 1000.
        BankAccount account = new BankAccount(1000);

        // Adds 500 to the account, so the balance becomes 1500.
        account.deposit(10000.50);

        // Withdraws 200, so the balance becomes 1300.
        account.withdraw(0);

        // Tries to withdraw 2000, but the withdrawal is rejected.
        account.withdraw(0);

        // Gets and displays the final balance.
        System.out.println("Balance: " + account.getBalance());
    }
}
