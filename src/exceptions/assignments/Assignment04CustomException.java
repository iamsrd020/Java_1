package exceptions.assignments;

public class Assignment04CustomException {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: Rs. 1000");

        try {
            account.withdraw(1500);
        } catch (InsufficientBalanceException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
