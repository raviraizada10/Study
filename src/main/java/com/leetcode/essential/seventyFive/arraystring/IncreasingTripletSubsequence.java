package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.GREEDY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, GREEDY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/increasing-triplet-subsequence/description/", problemNumber = "334", solutionLink = "https://algo.monster/liteproblems/334")
public class IncreasingTripletSubsequence {
    /**
     * Checks if there exists an increasing triplet (i, j, k) such that 0 <= i < j < k < nums.length and nums[i] < nums[j] < nums[k].
     * <p>
     * The strategy is to maintain two variables (`first` and `second`) to track the smallest and the second smallest elements encountered so far.
     * We iterate through the array and update these variables accordingly. If we find a number greater than both `first` and `second`,
     * we have found our increasing triplet and return true.
     *
     * @param nums An array of integers.
     * @return True if there exists an increasing triplet in the array; false otherwise.
     * <p>
     * Edge Cases:
     * - If the array has fewer than 3 elements, returns false as it's impossible to have an increasing triplet.
     * - Works correctly for arrays with negative numbers and duplicates.
     */
    public boolean increasingTriplet(int[] nums) {
        // Edge case: If the array has fewer than 3 elements, return false.
        if (nums.length < 3) {
            return false;
        }

        // Initialize two variables to track the smallest (`first`) and the second smallest (`second`) values.
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        // Traverse through the array.
        for (int num : nums) {
            // If the current number is smaller than or equal to `first`, update `first`.
            if (num <= first) {
                first = num;
            }
            // If the current number is greater than `first` but smaller than or equal to `second`, update `second`.
            else if (num <= second) {
                second = num;
            }
            // If the current number is greater than both `first` and `second`, return true (increasing triplet found).
            else {
                return true;
            }
        }

        // If no such triplet is found after traversing the array, return false.
        return false;
    }


}
