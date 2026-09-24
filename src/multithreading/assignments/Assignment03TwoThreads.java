package multithreading.assignments;

/*
 * Assignment 3: Start two independent workers.
 *
 * Both tasks can make progress at the same time. Do not expect a fixed
 * output order: the operating system scheduler chooses the winner.
 *
 * Interview point: concurrency does not guarantee ordering unless we add
 * coordination such as join, a lock, or an executor policy.
 */
public class Assignment03TwoThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> System.out.println("Task 1"));
        Thread thread2 = new Thread(() -> System.out.println("Task 2"));

        thread1.start();
        thread2.start();
        // We wait for both workers before main exits.
        thread1.join();
        thread2.join();
    }
}
