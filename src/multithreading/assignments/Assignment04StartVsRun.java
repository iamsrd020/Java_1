package multithreading.assignments;

/*
 * Assignment 4: Understand start() versus run().
 *
 * directCall.run() is like asking the current worker to do the job itself.
 * newThread.start() asks the JVM to create/schedule another worker.
 *
 * Expected direct-call order is Running, Main. The second Running comes from
 * the separately started thread. The exact scheduling of real threads varies.
 */
public class Assignment04StartVsRun {
    public static void main(String[] args) throws InterruptedException {
        MyThread directCall = new MyThread();
        // No new thread is created here.
        directCall.run();
        System.out.println("Main");

        MyThread newThread = new MyThread();
        // A new thread is created/scheduled here.
        newThread.start();
        newThread.join();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running");
        }
    }
}
