package oops;

public class Employee {
    // Private: accessible only inside the Employee class.
    private int employeeId;

    // Public: accessible from any class.
    public String name;

    // Protected: accessible in the same package and in child classes.
    protected double salary;

    // Default: accessible only by classes in the same package.
    String department;

    // Creates an employee and assigns values to all fields.
    public Employee(int employeeId, String name, double salary, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Public getter used to read the private employee ID safely.
    public int getEmployeeId() {
        return employeeId;
    }
}
