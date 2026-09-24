package multithreading.assignments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Assignment 13: SingleThreadExecutor.
 *
 * There is exactly one worker, so tasks execute one after another in
 * submission order. It is useful when work must be serialized.
 *
 * Interview point: it gives ordering, but not parallel execution.
 */
public class Assignment13SingleThreadExecutor {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
                int number = taskNumber;
                executor.submit(() -> System.out.println("Task " + number)).get();
            }
        } finally {
            executor.shutdown();
        }
    }
}
