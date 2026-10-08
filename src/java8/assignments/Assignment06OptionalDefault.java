package java8.assignments;

import java.util.Optional;

public class Assignment06OptionalDefault {
    public static void main(String[] args) {
        Optional<String> language = Optional.empty();
        String result = language.orElse("Unknown");

        System.out.println(result);
    }
}
