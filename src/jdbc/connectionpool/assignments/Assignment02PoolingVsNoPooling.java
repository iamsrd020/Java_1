package jdbc.connectionpool.assignments;

public class Assignment02PoolingVsNoPooling {
    public static void main(String[] args) {
        System.out.println("Without pooling: each request opens and closes a physical DB connection.");
        System.out.println("With pooling: requests borrow and return reusable connections.");
        System.out.println("Pooling usually reduces setup overhead and limits concurrent DB sessions.");
        System.out.println("It does not make a slow SQL query faster, and the pool must be sized carefully.");
    }
}
