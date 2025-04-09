package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/minimum-size-subarray-sum/description/", problemNumber = "209", solutionLink = "https://algo.monster/liteproblems/209")
public class MinSizeSubarraySum {
    /**
     * Finds the minimal length of a contiguous subarray of which the sum ≥ target.
     * Uses a sliding window approach to efficiently track valid subarrays.
     *
     * @param target the target sum to achieve or exceed
     * @param nums the input array of positive integers
     * @return the length of the smallest contiguous subarray with sum ≥ target, or 0 if none exists
     *
     * Edge Cases:
     * - If nums is empty or no such subarray exists, returns 0.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        // Expand the window by moving windowEnd
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            // Shrink the window while the sum is still ≥ target
            while (windowSum >= target) {
                // Update the minimum window size
                minWindowLength = Math.min(minWindowLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart]; // Slide window forward
                windowStart++;
            }
        }

        // If no valid window found, return 0
        return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
    }
}