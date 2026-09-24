package multithreading.assignments;

/*
 * Assignment 16: Avoid deadlock.
 *
 * Both workers always take lock1 first and lock2 second. Because nobody
 * takes the locks in the opposite order, a circular wait cannot form.
 *
 * Interview rule: define a global lock order and follow it everywhere.
 */
public class Assignment16AvoidDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Runnable task = () -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName()
                            + " acquired both locks");
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Deadlock avoided: both threads use lock1, then lock2.");
    }
}
