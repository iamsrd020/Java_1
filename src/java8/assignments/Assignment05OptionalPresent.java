package java8.assignments;

import java.util.Optional;

public class Assignment05OptionalPresent {
    public static void main(String[] args) {
        Optional<String> language = Optional.of("Java");
        language.ifPresent(System.out::println);
    }
}
