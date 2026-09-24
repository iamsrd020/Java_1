package multithreading.assignments;

/*
 * Assignment 5: Create a daemon thread.
 *
 * Child-friendly idea: a daemon is a background helper. The JVM does not
 * stay alive only for daemon helpers after all normal work is finished.
 *
 * Real example: monitoring or cleanup. Do not use a daemon for an important
 * payment or file save because the JVM may stop it without finishing.
 */
public class Assignment05DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread monitor = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Monitoring...");
                    Thread.sleep(50);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        // setDaemon must be called before start().
        monitor.setDaemon(true);
        monitor.start();

        Thread.sleep(120);
        System.out.println("Main task completed");
        monitor.interrupt();
        monitor.join();
    }
}
