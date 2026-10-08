package jdbc.connectionpool.assignments;

public class Assignment06WhyPoolingMatters {
    public static void main(String[] args) {
        System.out.println("Connection pooling is important in high-traffic applications because it:");
        System.out.println("1. Reuses connections instead of repeatedly creating physical connections.");
        System.out.println("2. Reduces connection setup latency and database connection overhead.");
        System.out.println("3. Caps concurrent connections so the database is not overwhelmed.");
        System.out.println("Requests wait when the bounded pool is busy, so pool sizing and timeouts matter.");
    }
}
