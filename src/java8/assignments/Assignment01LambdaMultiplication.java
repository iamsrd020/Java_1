package java8.assignments;

import java.util.function.BiFunction;

public class Assignment01LambdaMultiplication {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (first, second) -> first * second;
        System.out.println("Product: " + multiply.apply(6, 7));
    }
}
