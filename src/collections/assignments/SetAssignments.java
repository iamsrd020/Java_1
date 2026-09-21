package collections.assignments;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set assignments:
 * 1. HashSet
 * 2. LinkedHashSet
 * 3. TreeSet
 *
 * A Set does not store duplicate elements. The order in which elements are
 * displayed depends on the particular Set implementation.
 */
public class SetAssignments {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        hashSetAssignment();
        linkedHashSetAssignment();
        treeSetAssignment();
    }

    /*
     * HashSet assignment:
     * HashSet removes duplicate values automatically. It does not promise
     * insertion order, so the display order can look different from add order.
     */
    private static void hashSetAssignment() {
        System.out.println("\n===== HASHSET ASSIGNMENT =====");

        Set<String> students = new HashSet<>();
        students.add("Amit");
        students.add("Priya");
        students.add("Rahul");
        students.add("Sneha");
        students.add("Vikram");

        // This duplicate is ignored because "Amit" is already in the set.
        boolean duplicateAdded = students.add("Amit");
        System.out.println("Was duplicate Amit added? " + duplicateAdded);
        System.out.println("All student names: " + students);

        // contains() checks whether the requested value is present.
        System.out.println("Does the set contain Priya? "
                + students.contains("Priya"));

        // remove() deletes the requested student if it exists.
        students.remove("Rahul");
        System.out.println("Final HashSet: " + students);
    }

    /*
     * LinkedHashSet assignment:
     * It removes duplicates like HashSet, but also preserves insertion order.
     * Adding an existing name does not move it to the end.
     */
    private static void linkedHashSetAssignment() {
        System.out.println("\n===== LINKEDHASHSET ASSIGNMENT =====");

        Set<String> employees = new LinkedHashSet<>();
        employees.add("Arun");
        employees.add("Divya");
        employees.add("Kiran");
        employees.add("Meena");
        employees.add("Suresh");

        // Duplicate is ignored, and the original Arun remains in its place.
        employees.add("Arun");
        System.out.println("Employees after duplicate: " + employees);

        employees.remove("Kiran");
        employees.add("Nisha");

        // The remaining names still appear in insertion order.
        System.out.println("Final LinkedHashSet: " + employees);
    }

    /*
     * TreeSet assignment:
     * TreeSet removes duplicates and automatically sorts numbers in ascending
     * order when no custom Comparator is supplied.
     */
    private static void treeSetAssignment() {
        System.out.println("\n===== TREESET ASSIGNMENT =====");

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(47);
        numbers.add(12);
        numbers.add(89);
        numbers.add(3);
        numbers.add(65);
        numbers.add(28);
        numbers.add(94);
        numbers.add(17);
        numbers.add(51);
        numbers.add(76);

        // Duplicate 47 is ignored because Set values must be unique.
        numbers.add(47);
        System.out.println("Sorted numbers: " + numbers);
        System.out.println("Does the set contain 65? " + numbers.contains(65));

        numbers.remove(89);
        System.out.println("Final TreeSet: " + numbers);
    }
}
