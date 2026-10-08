package java8.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment02StreamFilterNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 31, 40, 8, 55);

        List<Integer> greaterThanThirty = numbers.stream()
                .filter(number -> number > 30)
                .collect(Collectors.toList());

        System.out.println("Numbers greater than 30: " + greaterThanThirty);
    }
}
