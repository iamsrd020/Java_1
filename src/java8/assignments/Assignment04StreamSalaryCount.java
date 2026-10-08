package java8.assignments;

import java.util.Arrays;
import java.util.List;

public class Assignment04StreamSalaryCount {
    public static void main(String[] args) {
        List<Integer> salaries = Arrays.asList(42000, 55000, 72000, 50000, 61000);

        long employeeCount = salaries.stream()
                .filter(salary -> salary > 50000)
                .count();

        System.out.println("Employees earning more than 50,000: " + employeeCount);
    }
}
