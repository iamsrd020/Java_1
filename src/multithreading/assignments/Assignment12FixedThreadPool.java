package multithreading.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Assignment 12: Five tasks with a fixed pool of two.
 *
 * Only two tasks can execute at once. The other tasks wait in the executor's
 * queue. This is useful when external resources, such as a database, have a
 * safe limit on simultaneous work.
 */
public class Assignment12FixedThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(
                        () -> System.out.println("Processing Task " + number)));
            }
        } finally {
            executor.shutdown();
        }
        for (Future<?> future : futures) {
            future.get();
        }
    }
}
