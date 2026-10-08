package jdbc.connectionpool.assignments;

public class Assignment01ConnectionReuse {
    public static void main(String[] args) {
        String[] connections = {"Connection 1", "Connection 2", "Connection 3"};

        for (int request = 0; request < connections.length; request++) {
            System.out.println("Request " + (request + 1) + " borrows "
                    + connections[request]);
        }

        System.out.println("Each request gets a different idle connection; exact order can vary.");
    }
}
