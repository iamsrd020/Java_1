package collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Map implementations:
 * HashMap       - fast key-value lookup with no ordering guarantee
 * LinkedHashMap - key-value lookup with predictable insertion order
 * TreeMap       - key-value pairs sorted by key
 */
public class MapDemo {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        hashMapExample();
        linkedHashMapExample();
        treeMapExample();
    }

    private static void hashMapExample() {
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Amit", 85);
        marks.put("Priya", 92);
        marks.put("Rahul", 78);
        marks.put("Amit", 90);

        System.out.println("HashMap: " + marks);
        System.out.println("HashMap Amit's marks: " + marks.get("Amit"));
    }

    private static void linkedHashMapExample() {
        Map<Integer, String> students = new LinkedHashMap<>();
        students.put(3, "Rahul");
        students.put(1, "Amit");
        students.put(2, "Priya");

        System.out.println("LinkedHashMap: " + students);
    }

    private static void treeMapExample() {
        TreeMap<Integer, String> students = new TreeMap<>();
        students.put(103, "Rahul");
        students.put(101, "Amit");
        students.put(102, "Priya");

        System.out.println("TreeMap: " + students);
        System.out.println("TreeMap first key: " + students.firstKey());
        System.out.println("TreeMap higher key than 101: "
                + students.higherKey(101));
    }
}
