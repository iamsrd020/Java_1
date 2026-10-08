package garbagecollection.assignments;

public class Assignment05IdentifyEligibleObject {
    public static void main(String[] args) {
        String a = new String("Java");
        String b = new String("Spring");

        a = null;

        System.out.println("The new String object formerly referenced by a is eligible for GC.");
        System.out.println("The new String object referenced by b is still reachable: " + b);
        System.out.println("The string literal objects may separately remain in the string pool.");
    }
}
