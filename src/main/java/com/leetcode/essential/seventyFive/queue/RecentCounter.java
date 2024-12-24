package com.leetcode.essential.seventyFive.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> queue; // Queue to store the timestamps of requests

    // Constructor to initialize the RecentCounter
    public RecentCounter() {
        queue = new LinkedList<>(); // Use LinkedList as a queue to efficiently handle operations
    }

    /**
     * Method to process a ping request.
     *
     * @param t The timestamp of the current request.
     * @return The number of requests that occurred in the past 3000 milliseconds (inclusive).
     */
    public int ping(int t) {
        // Step 1: Add the current timestamp to the queue
        queue.add(t);

        // Step 2: Remove outdated timestamps from the front of the queue
        // Only keep timestamps within the range [t-3000, t]
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll(); // Remove the timestamp at the front of the queue
        }

        // Step 3: Return the size of the queue
        // The size of the queue represents the number of valid requests
        return queue.size();
    }
}
