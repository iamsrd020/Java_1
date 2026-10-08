package garbagecollection.assignments;

public class Assignment02ReassignReference {
    public static void main(String[] args) {
        Object item = new Object();
        item = new Object();

        System.out.println("The original object is eligible for GC if item was its only reference.");
        System.out.println("The new object is reachable through item: " + item);
    }
}
