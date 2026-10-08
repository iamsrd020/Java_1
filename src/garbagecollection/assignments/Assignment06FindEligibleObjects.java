package garbagecollection.assignments;

public class Assignment06FindEligibleObjects {
    public static void main(String[] args) {
        String a = new String("Java");
        String b = new String("Spring");
        String c = new String("Boot");

        a = null;
        b = null;

        System.out.println("The new String objects formerly referenced by a and b are eligible "
                + "if no other references exist.");
        System.out.println("The new String object referenced by c is still reachable: " + c);
        System.out.println("The string literals may separately remain in the string pool.");
    }
}
