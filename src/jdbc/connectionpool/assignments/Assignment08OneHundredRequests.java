package jdbc.connectionpool.assignments;

public class Assignment08OneHundredRequests {
    public static void main(String[] args) {
        int requestCount = 100;
        int poolSize = 10;
        int batches = (requestCount + poolSize - 1) / poolSize;

        System.out.println(requestCount + " requests share " + poolSize + " pooled connections.");
        for (int batch = 0; batch < batches; batch++) {
            int firstRequest = batch * poolSize + 1;
            int lastRequest = Math.min(firstRequest + poolSize - 1, requestCount);
            System.out.println("Wave " + (batch + 1) + ": requests " + firstRequest + "-"
                    + lastRequest + " can borrow the connections.");
        }
        System.out.println("As each request finishes and closes its borrowed connection,");
        System.out.println("a waiting request can reuse it. The pool serves requests over time,");
        System.out.println("not as 100 simultaneous database operations.");
    }
}
