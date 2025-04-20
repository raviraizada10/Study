package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.PriorityQueue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/kth-largest-element-in-an-array/description/", problemNumber = "215", solutionLink = "https://algo.monster/liteproblems/215")
public class KthLargest {
    /**
     * 📝 Kth Largest Element in an Array – Min-Heap
     * Use a min-heap of size k to keep track of the top k largest elements.
     * Iterate through the array, inserting each number into the heap.
     * If the heap exceeds size k, remove the smallest element.
     * After processing all elements, the root of the heap is the k-th largest.
     *
     * @param nums the input array of integers
     * @param k    the 1-based index of the largest element to find
     * @return the k-th largest element in the array
     * <p>
     * Edge Cases:
     * - If nums is empty or k is invalid, behavior is undefined (as per problem constraints).
     * - If k == 1, returns the maximum element.
     * - If k == nums.length, returns the minimum element.
     */
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            // If size exceeds k, remove the smallest to keep only top k elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }
}