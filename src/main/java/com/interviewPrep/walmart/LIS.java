package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/longest-increasing-subsequence/description/", problemNumber = "300", solutionLink = "https://algo.monster/liteproblems/300")
public class LIS {
    /**
     * 📝 Longest Increasing Subsequence (LIS) – Dynamic Programming
     * Use a dynamic programming approach where lisAtIndex[i] stores the length of the longest increasing subsequence that ends at index i.
     * For each element, check all previous elements, and if the current element is greater, extend the subsequence.
     * The final answer is the maximum value in the lisAtIndex array.
     * Time complexity: O(n²).
     *
     * @param nums the input array of integers
     * @return the length of the longest increasing subsequence
     * <p>
     * Edge Cases:
     * - If nums is empty, returns 0.
     * - If nums has one element, returns 1.
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] lisAtIndex = new int[length];
        Arrays.fill(lisAtIndex, 1); // Each element is an increasing subsequence of length 1

        // Build the LIS array where lisAtIndex[i] stores the LIS ending at index i
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // If current number is greater, we can extend the subsequence ending at j
                if (nums[j] < nums[i]) {
                    lisAtIndex[i] = Math.max(lisAtIndex[i], lisAtIndex[j] + 1); // Update LIS length at i
                }
            }
        }

        // Find the maximum value in the LIS array
        int maxLIS = 0;
        for (int val : lisAtIndex) {
            maxLIS = Math.max(maxLIS, val); // Update the maximum LIS length found
        }

        return maxLIS;
    }
}