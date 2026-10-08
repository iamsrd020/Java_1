package exceptions.assignments;

public class Assignment02ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int index = 5;

        try {
            System.out.println("Value: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index " + index + " is outside the array bounds.");
        }
    }
}
