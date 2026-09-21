package collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Set implementations:
 * HashSet       - unique values with no ordering guarantee
 * LinkedHashSet - unique values in insertion order
 * TreeSet       - unique values in sorted order
 */
public class SetDemo {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        hashSetExample();
        linkedHashSetExample();
        treeSetExample();
    }

    private static void hashSetExample() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        numbers.add(10);

        System.out.println("HashSet: " + numbers);
        System.out.println("HashSet contains 20: " + numbers.contains(20));
    }

    private static void linkedHashSetExample() {
        Set<String> languages = new LinkedHashSet<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Java");

        System.out.println("LinkedHashSet: " + languages);
    }

    private static void treeSetExample() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(10);

        System.out.println("TreeSet: " + numbers);
        System.out.println("TreeSet lower than 30: " + numbers.lower(30));
        System.out.println("TreeSet higher than 30: " + numbers.higher(30));
    }
}
