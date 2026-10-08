package exceptions.assignments;

public class Assignment05FinallyBlock {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("The array index was out of bounds.");
        } finally {
            System.out.println("The finally block always executes.");
        }
    }
}
