package collections.queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Queue implementations:
 * PriorityQueue - removes elements according to priority
 * ArrayDeque    - modern, fast stack and double-ended queue
 *
 * LinkedList also implements Queue and Deque. ArrayDeque is normally preferred
 * when only queue/deque behavior is required.
 */
public class QueueDemo {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        priorityQueueExample();
        arrayDequeAsQueueExample();
        arrayDequeAsStackExample();
    }

    private static void priorityQueueExample() {
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(40);
        minHeap.offer(10);
        minHeap.offer(30);

        System.out.print("PriorityQueue (min): ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(10);
        maxHeap.offer(30);
        maxHeap.offer(20);
        System.out.println("PriorityQueue (max) head: " + maxHeap.peek());
    }

    private static void arrayDequeAsQueueExample() {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("First");
        queue.offer("Second");

        System.out.println("ArrayDeque as queue: " + queue);
        System.out.println("Queue removed: " + queue.poll());
    }

    private static void arrayDequeAsStackExample() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("ArrayDeque as stack top: " + stack.peek());
        System.out.println("ArrayDeque stack removed: " + stack.pop());
    }
}
