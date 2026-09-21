package collections.assignments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Map assignments:
 * 1. HashMap
 * 2. LinkedHashMap
 * 3. TreeMap
 *
 * A Map stores data as key-value pairs. Keys are unique, while values can
 * repeat. Putting a value with an existing key replaces the old value.
 */
public class MapAssignments {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        hashMapAssignment();
        linkedHashMapAssignment();
        treeMapAssignment();
    }

    /*
     * HashMap assignment:
     * HashMap provides key-based lookup. It does not guarantee display order.
     */
    private static void hashMapAssignment() {
        System.out.println("\n===== HASHMAP ASSIGNMENT =====");

        Map<Integer, String> students = new HashMap<>();
        students.put(101, "Amit");
        students.put(102, "Priya");
        students.put(103, "Rahul");
        students.put(104, "Sneha");
        students.put(105, "Vikram");

        System.out.println("All students: " + students);

        // get() uses the ID key to find the corresponding student name.
        System.out.println("Student with ID 103: " + students.get(103));

        // Putting a new value with ID 102 changes Priya to Ananya.
        students.put(102, "Ananya");

        // remove() deletes the entry belonging to ID 105.
        students.remove(105);

        // containsKey() checks whether a particular ID exists.
        System.out.println("Does ID 104 exist? " + students.containsKey(104));
        System.out.println("Final HashMap: " + students);
    }

    /*
     * LinkedHashMap assignment:
     * It behaves like HashMap but preserves the order in which keys were
     * first inserted. Updating an existing key does not create a new position.
     */
    private static void linkedHashMapAssignment() {
        System.out.println("\n===== LINKEDHASHMAP ASSIGNMENT =====");

        Map<Integer, String> employees = new LinkedHashMap<>();
        employees.put(201, "Arun");
        employees.put(202, "Divya");
        employees.put(203, "Kiran");
        employees.put(204, "Meena");
        employees.put(205, "Suresh");

        System.out.println("All employees: " + employees);

        // Existing ID 202 is updated; it does not create a duplicate key.
        employees.put(202, "Divya Sharma");
        employees.remove(204);
        employees.put(206, "Nisha");

        // The final output demonstrates predictable insertion order.
        System.out.println("Final LinkedHashMap: " + employees);
    }

    /*
     * TreeMap assignment:
     * TreeMap automatically sorts entries by their keys in ascending order
     * when no custom Comparator is supplied.
     */
    private static void treeMapAssignment() {
        System.out.println("\n===== TREEMAP ASSIGNMENT =====");

        Map<Integer, String> products = new TreeMap<>();
        products.put(503, "Keyboard");
        products.put(101, "Monitor");
        products.put(407, "Mouse");
        products.put(205, "Headphones");
        products.put(309, "Webcam");

        System.out.println("Products sorted by ID: " + products);

        // get() searches for a product by its ID.
        System.out.println("Product with ID 407: " + products.get(407));

        products.remove(205);
        System.out.println("Final TreeMap: " + products);
    }
}
