package java8.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment03StreamSquareNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());

        System.out.println("Squares: " + squares);
    }
}
