package exceptions.assignments;

public class Assignment01TryCatchDivision {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 0;

        try {
            System.out.println("Result: " + (dividend / divisor));
        } catch (ArithmeticException exception) {
            System.out.println("Cannot divide by zero.");
        }
    }
}
