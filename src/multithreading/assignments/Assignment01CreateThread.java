package multithreading.assignments;

/*
 * Assignment 1: Create a thread.
 *
 * Child-friendly idea: the main thread is one worker. We create a second
 * worker and give it one small job: print "Task is running".
 *
 * Interview point: start() creates/schedules a new thread. Calling run()
 * directly would only run the method on the current thread.
 */
public class Assignment01CreateThread {
    public static void main(String[] args) throws InterruptedException {
        // A lambda is the work that the new thread should perform.
        Thread thread = new Thread(() -> System.out.println("Task is running"));
        thread.start();
        // main waits so the example finishes after the child thread.
        thread.join();
    }
}
