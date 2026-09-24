package multithreading.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Multithreading assignments:
 * 1. Creating threads
 * 2. Runnable, synchronization, volatile, and daemon threads
 * 3. ExecutorService and Callable
 * 4. Deadlock and deadlock prevention
 *
 * Thread output order is not fixed. The operating system and JVM decide which
 * ready thread gets CPU time first.
 */
public class MultithreadingAssignments {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        run();
    }

    public static void run() throws InterruptedException, ExecutionException {
        createThread();
        createThreadUsingRunnable();
        createTwoThreads();
        startVsRun();
        daemonThread();
        synchronizedWithdrawal();
        volatileFlag();

        basicExecutorService();
        multipleTasks();
        executorWithRunnable();
        executorWithCallable();
        fixedThreadPool();
        singleThreadExecutor();
        callableTaskResults();

        createDeadlock();
        avoidDeadlock();
        identifyDeadlock();
    }

    // Assignment 1: Create a thread by extending Thread.
    private static void createThread() throws InterruptedException {
        System.out.println("\n===== CREATE A THREAD =====");

        Thread thread = new Thread(() -> System.out.println("Task is running"));
        thread.start();
        thread.join();
    }

    // Assignment 2: Create a thread using Runnable.
    private static void createThreadUsingRunnable() throws InterruptedException {
        System.out.println("\n===== THREAD USING RUNNABLE =====");

        Runnable task = () -> System.out.println("Processing Task");
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
    }

    // Assignment 3: Start two independent threads.
    private static void createTwoThreads() throws InterruptedException {
        System.out.println("\n===== TWO THREADS =====");

        Thread thread1 = new Thread(() -> System.out.println("Task 1"));
        Thread thread2 = new Thread(() -> System.out.println("Task 2"));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    // Assignment 4: run() is an ordinary method call; start() creates a new thread.
    private static void startVsRun() throws InterruptedException {
        System.out.println("\n===== start() VS run() =====");

        MyThread thread = new MyThread();
        thread.run();
        System.out.println("Main");

        Thread realThread = new MyThread();
        realThread.start();
        realThread.join();
    }

    // Assignment 5: A daemon thread does background work for a short-lived main task.
    private static void daemonThread() throws InterruptedException {
        System.out.println("\n===== DAEMON THREAD =====");

        Thread monitor = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Monitoring...");
                    Thread.sleep(50);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        monitor.setDaemon(true);
        monitor.start();

        Thread.sleep(120);
        System.out.println("Main task completed");
        monitor.interrupt();
        monitor.join();
    }

    // Assignment 6: synchronized prevents both withdrawals from changing the
    // balance at the same time.
    private static void synchronizedWithdrawal() throws InterruptedException {
        System.out.println("\n===== SYNCHRONIZATION =====");

        BankAccount account = new BankAccount(1000);
        Runnable withdrawal = () -> account.withdraw(700);

        Thread thread1 = new Thread(withdrawal, "Customer 1");
        Thread thread2 = new Thread(withdrawal, "Customer 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final balance: ₹" + account.getBalance());
    }

    // Assignment 7: volatile makes the latest value visible to both threads.
    private static void volatileFlag() throws InterruptedException {
        System.out.println("\n===== volatile =====");

        RunningFlag flag = new RunningFlag();
        Thread worker = new Thread(() -> {
            while (flag.isRunning) {
                // The worker repeatedly reads the shared volatile flag.
            }
            System.out.println("Worker stopped because isRunning became false");
        });
        Thread stopper = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            flag.isRunning = false;
        });

        worker.start();
        stopper.start();
        worker.join();
        stopper.join();
    }

    // ExecutorService assignment 1.
    private static void basicExecutorService() throws InterruptedException, ExecutionException {
        System.out.println("\n===== BASIC EXECUTOR SERVICE =====");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 3; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(() -> System.out.println("Task " + number)));
            }
        } finally {
            executor.shutdown();
        }
        waitForTasks(futures);
    }

    // ExecutorService assignment 2.
    private static void multipleTasks() throws InterruptedException, ExecutionException {
        System.out.println("\n===== MULTIPLE TASKS =====");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(
                        () -> System.out.println("Task is running: " + number)));
            }
            waitForTasks(futures);
        } finally {
            executor.shutdown();
        }
    }

    // ExecutorService assignment 3.
    private static void executorWithRunnable() throws InterruptedException, ExecutionException {
        System.out.println("\n===== EXECUTOR WITH RUNNABLE =====");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = new ArrayList<>();
        try {
            Runnable orderTask = () -> System.out.println("Processing Order");
            for (int count = 0; count < 5; count++) {
                futures.add(executor.submit(orderTask));
            }
            waitForTasks(futures);
        } finally {
            executor.shutdown();
        }
    }

    // ExecutorService assignment 4.
    private static void executorWithCallable() throws InterruptedException, ExecutionException {
        System.out.println("\n===== EXECUTOR WITH CALLABLE =====");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Callable<Integer> sumTask = () -> 10 + 20;
            Future<Integer> result = executor.submit(sumTask);
            System.out.println("10 + 20 = " + result.get());
        } finally {
            executor.shutdown();
        }
    }

    // Executor Framework assignment 5.
    private static void fixedThreadPool() throws InterruptedException, ExecutionException {
        System.out.println("\n===== FIXED THREAD POOL =====");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(
                        () -> System.out.println("Processing Task " + number)));
            }
            waitForTasks(futures);
        } finally {
            executor.shutdown();
        }
    }

    // Executor Framework assignment 6: one worker preserves submission order.
    private static void singleThreadExecutor() throws InterruptedException, ExecutionException {
        System.out.println("\n===== SINGLE THREAD EXECUTOR =====");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<Future<?>> futures = new ArrayList<>();
        try {
            for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {
                int number = taskNumber;
                futures.add(executor.submit(() -> System.out.println("Task " + number)));
            }
            waitForTasks(futures);
        } finally {
            executor.shutdown();
        }
    }

    // Executor Framework assignment 7.
    private static void callableTaskResults() throws InterruptedException, ExecutionException {
        System.out.println("\n===== CALLABLE TASK RESULTS =====");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            List<Callable<Integer>> tasks = List.of(
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

    // Assignment 8: The two daemon threads intentionally wait forever.
    // join(timeout) lets this teaching example continue instead of hanging.
    private static void createDeadlock() throws InterruptedException {
        System.out.println("\n===== CREATE A DEADLOCK =====");

        Object lock1 = new Object();
        Object lock2 = new Object();
        CountDownLatch firstLocksAcquired = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                firstLocksAcquired.countDown();
                waitForOtherThread(firstLocksAcquired);
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired both locks");
                }
            }
        }, "Thread 1");
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                firstLocksAcquired.countDown();
                waitForOtherThread(firstLocksAcquired);
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

        if (thread1.isAlive() && thread2.isAlive()) {
            System.out.println("Deadlock created: each thread holds one lock and waits for the other.");
        }
    }

    // Assignment 9: Both threads acquire lock1 before lock2, so circular wait
    // cannot occur.
    private static void avoidDeadlock() throws InterruptedException {
        System.out.println("\n===== AVOID DEADLOCK =====");

        Object lock1 = new Object();
        Object lock2 = new Object();
        Runnable task = () -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired both locks");
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Deadlock avoided because both threads use the same lock order.");
    }

    // Assignment 10: Explain the Lock A/Lock B situation in executable form.
    private static void identifyDeadlock() {
        System.out.println("\n===== IDENTIFY DEADLOCK =====");
        System.out.println("Thread 1 holds Lock A and waits for Lock B.");
        System.out.println("Thread 2 holds Lock B and waits for Lock A.");
        System.out.println("The deadlock occurs because the threads form a circular wait.");
        System.out.println("Prevent it with a consistent lock order, timeout, or fewer nested locks.");
    }

    private static void waitForTasks(List<Future<?>> futures)
            throws InterruptedException, ExecutionException {
        for (Future<?> future : futures) {
            future.get();
        }
    }

    private static void waitForOtherThread(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running");
        }
    }

    private static class BankAccount {
        private int balance;

        private BankAccount(int balance) {
            this.balance = balance;
        }

        private synchronized void withdraw(int amount) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName()
                        + " withdrew ₹" + amount);
                balance -= amount;
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not withdraw ₹" + amount + " (insufficient balance)");
            }
        }

        private int getBalance() {
            return balance;
        }
    }

    private static class RunningFlag {
        private volatile boolean isRunning = true;
    }
}
