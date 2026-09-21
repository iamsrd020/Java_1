package collections;

import collections.list.ListDemo;
import collections.map.MapDemo;
import collections.queue.QueueDemo;
import collections.set.SetDemo;

/*
 * Entry point for the complete Java Collections Framework practice folder.
 *
 * Run this class when you want to see all collection categories together.
 * Each category also has its own main method for focused practice.
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        System.out.println("===== LIST =====");
        ListDemo.run();

        System.out.println("\n===== SET =====");
        SetDemo.run();

        System.out.println("\n===== QUEUE =====");
        QueueDemo.run();

        System.out.println("\n===== MAP =====");
        MapDemo.run();
    }
}
