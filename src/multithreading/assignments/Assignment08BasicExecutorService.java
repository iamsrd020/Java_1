package multithreading.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Assignment 8: Basic ExecutorService.
 *
 * Think of a pool as two reusable workers. We give them three tasks. Two may
 * start first; the third waits until a worker becomes free.
 *
 * shutdown() means "accept no new tasks, but finish submitted tasks".
 * Future.get() lets this small demo wait for every task to finish.
 */
public class Assignment08BasicExecutorService {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 3; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(() -> System.out.println("Task " + number)));
            }
        } finally {
            executor.shutdown();
        }
        for (Future<?> future : futures) {
            future.get();
        }
    }
}
