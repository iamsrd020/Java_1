package garbagecollection.assignments;

public class Assignment04RequestGc {
    public static void main(String[] args) {
        Object item = new Object();
        System.out.println("Created an object: " + item);

        item = null;
        System.out.println("The object is eligible for GC.");
        System.gc();
        System.out.println("Requested GC; the JVM is not required to collect the object now.");
    }
}
