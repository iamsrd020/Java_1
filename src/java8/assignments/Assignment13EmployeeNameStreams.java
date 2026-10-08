package java8.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment13EmployeeNameStreams {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("Sai", "Rahul", "John", "Priya", "Suresh");

        System.out.println("All employees:");
        employees.stream().forEach(System.out::println);

        List<String> namesStartingWithS = employees.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("Names starting with S: " + namesStartingWithS);

        List<String> uppercaseNames = employees.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + uppercaseNames);

        long employeeCount = employees.stream().count();
        System.out.println("Total employees: " + employeeCount);
    }
}
