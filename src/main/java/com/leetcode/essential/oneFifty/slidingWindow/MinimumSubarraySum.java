package com.leetcode.essential.oneFifty.slidingWindow;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, BINARY_SEARCH, SLIDING_WINDOW, PREFIX_SUM})
@ProblemInfo(problemLink = "https://leetcode.com/problems/minimum-size-subarray-sum/description/", problemNumber = "209", solutionLink = "https://algo.monster/liteproblems/209")
public class MinimumSubarraySum {
    /**
     * Finds the minimum length of a contiguous subarray whose sum is at least the given target.
     *
     * @param target The target sum that the subarray should meet or exceed.
     * @param nums   The input array of positive integers.
     * @return The length of the smallest subarray with a sum >= target; returns 0 if no valid subarray exists.
     * <p>
     * The approach used is the sliding window technique, which efficiently finds the optimal subarray
     * in O(n) time complexity by dynamically adjusting the window size.
     */
    public int minSubArrayLen(int target, int[] nums) {
        // Initialize two pointers and necessary variables
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE; // Stores the smallest valid subarray length

        // Expand the right boundary of the window
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // Include the current element in the sum

            // Shrink the window from the left while the sum is at least the target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1); // Update minimum length
                sum -= nums[left]; // Remove the leftmost element
                left++; // Move the left boundary to the right
            }
        }

        // If no valid subarray was found, return 0; otherwise, return the minimum length found
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}   