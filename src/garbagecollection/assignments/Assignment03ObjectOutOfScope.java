package garbagecollection.assignments;

public class Assignment03ObjectOutOfScope {
    public static void main(String[] args) {
        createObjectInMethod();
        System.out.println("The method returned. Its local reference is gone.");
        System.out.println("The object may now be eligible if no other reference escaped.");
    }

    private static void createObjectInMethod() {
        Object localObject = new Object();
        System.out.println("Created an object inside the method: " + localObject);
    }
}
