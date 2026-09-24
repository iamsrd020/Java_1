package multithreading.assignments;

/*
 * Assignment 2: Use Runnable.
 *
 * Runnable is the task, like a recipe. Thread is the worker who follows the
 * recipe. Keeping them separate is preferred in real Java code.
 *
 * Interview point: Runnable has run() and does not return a result. Callable
 * is used when the task must return a value.
 */
public class Assignment02ThreadUsingRunnable {
    public static void main(String[] args) throws InterruptedException {
        // This object describes what should happen, not who executes it.
        Runnable task = () -> System.out.println("Processing Task");
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
    }
}
