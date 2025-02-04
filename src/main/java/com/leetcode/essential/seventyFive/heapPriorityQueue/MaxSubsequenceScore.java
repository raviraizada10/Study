package com.leetcode.essential.seventyFive.heapPriorityQueue;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, GREEDY, SORTING, HEAP})
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-subsequence-score/description/", problemNumber = "2542", solutionLink = "https://algo.monster/liteproblems/2542")
public class MaxSubsequenceScore {
    /**
     * Computes the maximum possible score by selecting exactly `k` elements from `nums1`,
     * multiplying their sum with the minimum value of corresponding elements in `nums2`.
     *
     * @param nums1 An array of integers.
     * @param nums2 An array of integers of the same length as `nums1`.
     * @param k     The number of elements to select.
     * @return The maximum achievable score.
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairedNumbers = new int[n][2];

        // Pairing elements from nums1 and nums2
        for (int i = 0; i < n; i++) {
            pairedNumbers[i] = new int[]{nums1[i], nums2[i]};
        }

        // Sort the pairs based on nums2 values in descending order
        Arrays.sort(pairedNumbers, (a, b) -> b[1] - a[1]);

        // Min-Heap to maintain the largest `k` elements from nums1
        Queue<Integer> minHeap = new PriorityQueue<>();
        long maxScore = 0;
        long sumOfSelected = 0;

        // Iterate through the sorted list and maintain a heap of `k` largest elements from nums1
        for (int i = 0; i < n; i++) {
            int num1Value = pairedNumbers[i][0];
            int num2Value = pairedNumbers[i][1];

            // Add the num1Value to the current sum and push it to the heap
            sumOfSelected += num1Value;
            minHeap.offer(num1Value);

            // Ensure we only consider `k` elements at a time
            if (minHeap.size() == k) {
                // Calculate the score and update maxScore if it's the highest seen so far
                maxScore = Math.max(maxScore, sumOfSelected * num2Value);

                // Remove the smallest element from the heap to maintain exactly `k` elements
                sumOfSelected -= minHeap.poll();
            }
        }
        return maxScore;
    }
}   