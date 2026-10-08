package jdbc.connectionpool.assignments;

public class Assignment04AllConnectionsBusy {
    public static void main(String[] args) {
        System.out.println("The third request cannot use either busy connection.");
        System.out.println("It waits until a connection is returned to the pool.");
        System.out.println("If the connection timeout expires first, acquisition fails with a timeout.");
    }
}
