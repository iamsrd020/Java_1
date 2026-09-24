package multithreading.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Assignment 9: Five tasks with three workers.
 *
 * Three cooks can work first. The remaining two orders wait in the queue.
 * Output order is not guaranteed because workers run independently.
 *
 * Interview point: a fixed pool limits the number of simultaneously running
 * tasks and reuses threads instead of creating one thread per task.
 */
public class Assignment09MultipleTasks {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(
                        () -> System.out.println("Task is running: " + number)));
            }
        } finally {
            executor.shutdown();
        }
        for (Future<?> future : futures) {
            future.get();
        }
    }
}
