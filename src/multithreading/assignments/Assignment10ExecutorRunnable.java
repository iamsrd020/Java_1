package multithreading.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Assignment 10: Submit the same Runnable five times.
 *
 * Runnable is reusable work. Each submit creates a separate execution of that
 * work. The pool decides which worker executes each copy.
 */
public class Assignment10ExecutorRunnable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = new ArrayList<>();
        try {
            Runnable task = () -> System.out.println("Processing Order");
            for (int count = 0; count < 5; count++) {
                futures.add(executor.submit(task));
            }
        } finally {
            executor.shutdown();
        }
        for (Future<?> future : futures) {
            future.get();
        }
    }
}
