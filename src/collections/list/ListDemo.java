package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/*
 * List implementations:
 * ArrayList  - best default choice for index-based access
 * LinkedList - list plus queue/deque operations
 * Vector     - legacy synchronized dynamic array
 * Stack      - legacy LIFO structure that extends Vector
 */
public class ListDemo {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        arrayListExample();
        linkedListExample();
        vectorExample();
        stackExample();
    }

    private static void arrayListExample() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Banana");

        fruits.set(1, "Orange");
        System.out.println("ArrayList: " + fruits);
        System.out.println("ArrayList index 0: " + fruits.get(0));
    }

    private static void linkedListExample() {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.addFirst("Chennai");
        cities.addLast("Bangalore");

        System.out.println("LinkedList: " + cities);
        System.out.println("LinkedList removed first: " + cities.removeFirst());
    }

    private static void vectorExample() {
        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Vector: " + numbers);
    }

    private static void stackExample() {
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack top: " + stack.peek());
        System.out.println("Stack removed: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
}
