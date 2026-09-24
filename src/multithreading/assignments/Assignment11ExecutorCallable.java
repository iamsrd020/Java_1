package multithreading.assignments;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Assignment 11: Callable and Future.
 *
 * Runnable says "do something"; Callable says "do something and give me a
 * result". Future is the promise/receipt for that result.
 *
 * get() waits if the answer is not ready and can report task exceptions.
 */
public class Assignment11ExecutorCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Callable<Integer> sum = () -> 10 + 20;
            Future<Integer> result = executor.submit(sum);
            System.out.println("10 + 20 = " + result.get());
        } finally {
            executor.shutdown();
        }
    }
}
