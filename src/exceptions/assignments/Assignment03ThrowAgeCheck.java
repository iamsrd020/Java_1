package exceptions.assignments;

public class Assignment03ThrowAgeCheck {
    public static void main(String[] args) {
        checkAge(20);

        try {
            checkAge(16);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18.");
        }

        System.out.println("Valid age");
    }
}
