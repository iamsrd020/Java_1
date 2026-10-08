package java8.assignments;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Assignment14EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Sai", 48000, LocalDate.of(2022, 3, 14)),
                new Employee(102, "Rahul", 62000, LocalDate.of(2020, 7, 1)),
                new Employee(103, "Priya", 75000, LocalDate.of(2019, 11, 20)));

        BiFunction<Double, Double, Double> addBonus = (salary, bonus) -> salary + bonus;
        System.out.println("Sai's salary after bonus: "
                + addBonus.apply(employees.get(0).getSalary(), 5000.0));

        List<Employee> highEarners = employees.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .collect(Collectors.toList());
        System.out.println("Employees earning more than 50,000:");
        highEarners.forEach(System.out::println);

        Optional<Employee> foundEmployee = findEmployeeById(employees, 102);
        if (foundEmployee.isPresent()) {
            System.out.println("Found employee: " + foundEmployee.get());
        } else {
            System.out.println("Employee not found.");
        }

        Optional<Employee> missingEmployee = findEmployeeById(employees, 999);
        if (missingEmployee.isPresent()) {
            System.out.println("Found employee: " + missingEmployee.get());
        } else {
            System.out.println("Employee with ID 999 not found.");
        }

        EmployeeOperations operations = new EmployeeOperations() {
        };
        operations.displayCompanyName();

        System.out.println("Joining date for " + employees.get(0).getName()
                + ": " + employees.get(0).getJoiningDate());
    }

    private static Optional<Employee> findEmployeeById(List<Employee> employees, int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    private interface EmployeeOperations {
        default void displayCompanyName() {
            System.out.println("Company: Example Technologies");
        }
    }

    private static class Employee {
        private final int id;
        private final String name;
        private final double salary;
        private final LocalDate joiningDate;

        private Employee(int id, String name, double salary, LocalDate joiningDate) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.joiningDate = joiningDate;
        }

        private int getId() {
            return id;
        }

        private String getName() {
            return name;
        }

        private double getSalary() {
            return salary;
        }

        private LocalDate getJoiningDate() {
            return joiningDate;
        }

        @Override
        public String toString() {
            return name + " (ID " + id + ", salary " + salary
                    + ", joined " + joiningDate + ")";
        }
    }
}
