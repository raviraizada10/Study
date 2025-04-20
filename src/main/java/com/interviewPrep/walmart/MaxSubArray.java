package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-subarray/", problemNumber = "53", solutionLink = "https://algo.monster/liteproblems/53")
public class MaxSubArray {
    /**
     * 📝 Maximum Subarray – Kadane’s Algorithm
     * Iterate through the array while tracking the current subarray sum.
     * At each index, decide whether to extend the current subarray or start a new one using Math.max(current, current + previousSum).
     * Keep updating the maximum sum seen so far.
     * Works efficiently in O(n) time, even with negative numbers.
     *
     * @param nums the input array of integers
     * @return the maximum sum of any contiguous subarray
     * <p>
     * Edge Cases:
     * - If nums has one element, returns that element.
     * - Handles arrays with all negative values correctly.
     */
    public int maxSubArray(int[] nums) {
        // Initialize with the first element
        int currentSubarraySum = nums[0];
        int maxSubarraySum = nums[0];

        // Traverse from the second element
        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start a new subarray at current index
            currentSubarraySum = Math.max(nums[i], currentSubarraySum + nums[i]);

            // Update the max found so far
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
        }

        return maxSubarraySum;
    }
}