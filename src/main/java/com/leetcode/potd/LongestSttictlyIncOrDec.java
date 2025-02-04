package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/", problemNumber = "3105", solutionLink = "https://algo.monster/liteproblems/3105")
public class LongestSttictlyIncOrDec {
    /**
     * Finds the length of the longest strictly monotonic (either increasing or decreasing) subarray.
     *
     * <p>A strictly increasing subarray means each element is greater than the previous one,
     * while a strictly decreasing subarray means each element is smaller than the previous one.</p>
     *
     * @param nums An array of integers.
     * @return The maximum length of any strictly increasing or strictly decreasing subarray.
     *
     * <p><b>Time Complexity:</b> O(N) - We iterate through the array once.
     * <br><b>Space Complexity:</b> O(1) - Uses only a few integer variables.</p>
     *
     * <p><b>Edge Cases Considered:</b>
     * <ul>
     *   <li>An empty array → returns 0</li>
     *   <li>A single-element array → returns 1</li>
     *   <li>An array where all elements are equal → returns 1</li>
     *   <li>A fully increasing or decreasing array → returns its full length</li>
     * </ul>
     * </p>
     */
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // No elements, no valid subarray
        }

        int maxIncreasingLength = 1, maxDecreasingLength = 1; // Stores longest subarray lengths
        int currIncreasing = 1, currDecreasing = 1; // Tracks the length of current increasing/decreasing subarrays

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                // Increasing sequence continues
                currIncreasing++;
                currDecreasing = 1; // Reset decreasing count
            }
            else if (nums[i] < nums[i - 1]) {
                // Decreasing sequence continues
                currDecreasing++;
                currIncreasing = 1; // Reset increasing count
            }
            else {
                // Reset both counts if there's a duplicate element
                currIncreasing = 1;
                currDecreasing = 1;
            }

            // Update max lengths found so far
            maxIncreasingLength = Math.max(maxIncreasingLength, currIncreasing);
            maxDecreasingLength = Math.max(maxDecreasingLength, currDecreasing);
        }

        return Math.max(maxIncreasingLength, maxDecreasingLength);
    }
}   