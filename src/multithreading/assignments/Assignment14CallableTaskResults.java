package multithreading.assignments;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Assignment 14: Collect results from three Callable tasks.
 *
 * invokeAll submits the group and returns Futures in the same list order as
 * the submitted tasks. The tasks may execute in parallel, but we print their
 * results by reading the Futures.
 */
public class Assignment14CallableTaskResults {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            List<Callable<Integer>> tasks = Arrays.asList(
                    () -> 10,
                    () -> 20,
                    () -> 30
            );
            List<Future<Integer>> results = executor.invokeAll(tasks);
            for (Future<Integer> result : results) {
                System.out.println("Result: " + result.get());
            }
        } finally {
            executor.shutdown();
        }
    }
}
