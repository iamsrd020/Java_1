package multithreading.assignments;

/*
 * Assignment 17: Explain a deadlock without running one.
 *
 * Lock A is held by Thread 1, while Thread 2 holds Lock B. Each thread waits
 * for the other lock. This is circular waiting.
 *
 * Prevention: consistent lock order, tryLock with a timeout, or fewer nested
 * locks. In production, thread dumps help locate the cycle.
 */
public class Assignment17IdentifyDeadlock {
    public static void main(String[] args) {
        System.out.println("Thread 1 holds Lock A and waits for Lock B.");
        System.out.println("Thread 2 holds Lock B and waits for Lock A.");
        System.out.println("This is circular waiting, so neither thread can continue.");
        System.out.println("Prevent it with one global lock order, tryLock timeout,");
        System.out.println("or fewer nested locks.");
    }
}
