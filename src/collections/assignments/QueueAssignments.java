package collections.assignments;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Queue assignments:
 * 1. PriorityQueue
 * 2. Task processing using Queue
 *
 * Queue methods used here:
 * offer() adds an element,
 * peek() views the next element without removing it,
 * poll() removes and returns the next element,
 * isEmpty() checks whether work remains.
 */
public class QueueAssignments {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        priorityQueueAssignment();
        taskQueueAssignment();
    }

    /*
     * PriorityQueue assignment:
     * Java's default PriorityQueue is a min-heap, so the smallest number is
     * returned first. The numbers are processed by priority, not add order.
     */
    private static void priorityQueueAssignment() {
        System.out.println("\n===== PRIORITYQUEUE ASSIGNMENT =====");

        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.offer(45);
        numbers.offer(10);
        numbers.offer(30);
        numbers.offer(5);
        numbers.offer(25);

        // peek() only observes the next number; it leaves the queue unchanged.
        System.out.println("Number processed first: " + numbers.peek());

        // poll() removes numbers one by one according to priority.
        System.out.print("Processing order: ");
        while (!numbers.isEmpty()) {
            System.out.print(numbers.poll() + " ");
        }
        System.out.println();
    }

    /*
     * Task processing assignment:
     * A normal Queue follows FIFO: the first task added is the first task
     * processed. ArrayDeque is a modern queue implementation, but the Queue
     * interface is used so the code focuses on queue behavior.
     */
    private static void taskQueueAssignment() {
        System.out.println("\n===== TASK PROCESSING ASSIGNMENT =====");

        Queue<String> tasks = new java.util.ArrayDeque<>();
        tasks.offer("Login");
        tasks.offer("Process Payment");
        tasks.offer("Send Email");
        tasks.offer("Generate Report");

        // peek() shows the next task without processing it.
        System.out.println("Next task: " + tasks.peek());

        // Continue until every task has been removed and completed.
        while (!tasks.isEmpty()) {
            String currentTask = tasks.poll();
            System.out.println("Processing task: " + currentTask);
            System.out.println("Remaining tasks: " + tasks);
        }

        // isEmpty() is true because poll() removed every task.
        System.out.println("Are all tasks completed? " + tasks.isEmpty());
    }
}
