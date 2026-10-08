package garbagecollection.assignments;

public class Assignment01EligibleForGc {
    public static void main(String[] args) {
        Object item = new Object();
        System.out.println("Created an object: " + item);

        item = null;
        System.out.println("The only reference was removed; the object is eligible for GC.");
    }
}
