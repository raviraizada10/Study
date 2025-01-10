package com.leetcode.essential.seventyFive.heapPriorityQueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
    // The current smallest number in the infinite set
    private int currentSmallest;

    // A min-heap to store numbers that were added back to the set
    private PriorityQueue<Integer> minHeap;

    // A set to keep track of numbers added back to avoid duplicates
    private Set<Integer> addedBackNumbers;

    /**
     * Constructor to initialize the SmallestInfiniteSet.
     * The set starts with all positive integers, beginning at 1.
     */
    public SmallestInfiniteSet() {
        currentSmallest = 1; // Start from the smallest positive integer
        minHeap = new PriorityQueue<>(); // Priority queue for managing added-back numbers
        addedBackNumbers = new HashSet<>(); // Set to track numbers in the min-heap
    }

    /**
     * Removes and returns the smallest number in the set.
     * If there are numbers in the min-heap smaller than `currentSmallest`, they take priority.
     * Otherwise, `currentSmallest` is returned and incremented.
     *
     * @return The smallest number in the set.
     */
    public int popSmallest() {
        // Check if the min-heap has numbers smaller than `currentSmallest`
        if (!minHeap.isEmpty() && minHeap.peek() < currentSmallest) {
            int smallest = minHeap.poll(); // Remove the smallest number from the heap
            addedBackNumbers.remove(smallest); // Remove it from the set
            return smallest; // Return the popped number
        }
        // If no numbers in the heap are smaller, return `currentSmallest` and increment it
        return currentSmallest++;
    }

    /**
     * Adds a number back into the set if it is smaller than `currentSmallest`
     * and not already present in the set.
     *
     * @param num The number to add back into the set.
     */
    public void addBack(int num) {
        // Only add the number if it is smaller than `currentSmallest` and not already added back
        if (num < currentSmallest && addedBackNumbers.add(num)) {
            minHeap.add(num); // Add the number to the min-heap
        }
    }
}
