package multithreading.assignments;

import java.util.concurrent.CountDownLatch;

/*
 * Assignment 15: Intentionally create a deadlock.
 *
 * Thread 1 takes lock1 and waits for lock2. Thread 2 takes lock2 and waits
 * for lock1. Each holds what the other needs, so both wait forever.
 *
 * The threads are daemon threads and join has a timeout so this learning
 * program can finish instead of freezing the whole application.
 */
public class Assignment15CreateDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        CountDownLatch bothFirstLocksHeld = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                bothFirstLocksHeld.countDown();
                await(bothFirstLocksHeld);
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired both locks");
                }
            }
        }, "Thread 1");
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                bothFirstLocksHeld.countDown();
                await(bothFirstLocksHeld);
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired both locks");
                }
            }
        }, "Thread 2");

        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread1.start();
        thread2.start();
        thread1.join(100);
        thread2.join(100);
        System.out.println("Deadlock created: each thread holds one lock and waits for the other.");
    }

    private static void await(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
