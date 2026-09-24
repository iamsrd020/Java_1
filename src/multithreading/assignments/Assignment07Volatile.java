package multithreading.assignments;

/*
 * Assignment 7: Use volatile for visibility.
 *
 * One worker keeps checking the flag. Another worker changes it to false.
 * volatile tells the JVM that the worker must see the latest value, rather
 * than safely reusing an old cached value.
 *
 * Interview point: volatile does not make count++ atomic. It is suitable for
 * simple flags, not for multi-step updates.
 */
public class Assignment07Volatile {
    private static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (isRunning) {
                // The loop ends when the other thread writes false.
            }
            System.out.println("Worker stopped");
        });
        Thread stopper = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            isRunning = false;
        });

        worker.start();
        stopper.start();
        worker.join();
        stopper.join();
    }
}
