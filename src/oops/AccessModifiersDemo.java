package oops;

public class AccessModifiersDemo {
    // Program execution starts from the main method.
    public static void main(String[] args) {
        // Creates an Employee object with sample employee details.
        Employee employee = new Employee(101, "Darshan", 50000, "IT");

        // The private ID is accessed through a public getter method.
        System.out.println("Private employee ID: " + employee.getEmployeeId());

        // Public fields can be accessed directly from any class.
        System.out.println("Public name: " + employee.name);

        // Protected fields can be accessed directly because this class
        // belongs to the same package as Employee.
        System.out.println("Protected salary: " + employee.salary);

        // Default fields can be accessed directly inside the same package.
        System.out.println("Default department: " + employee.department);
    }
}
