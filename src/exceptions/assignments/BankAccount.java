package exceptions.assignments;

public class BankAccount {
    private int balance = 1000;

    public void withdraw(int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: Rs. " + balance);
    }
}
