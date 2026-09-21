package collections.assignments;

import java.util.ArrayList;
import java.util.List;

/*
 * Assignment: Create a list containing three names and print them.
 *
 * ArrayList is used here because it is the common general-purpose List
 * implementation. A List preserves insertion order and allows duplicates.
 */
public class ListAssignment {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println("\n===== LIST ASSIGNMENT =====");

        // The diamond operator lets Java infer that this is a List<String>.
        List<String> names = new ArrayList<>();

        // add() appends each name to the end of the list.
        names.add("Darshan");
        names.add("Priya");
        names.add("Rahul");

        // List.toString() displays all elements in their insertion order.
        System.out.println("Three names: " + names);
    }
}
