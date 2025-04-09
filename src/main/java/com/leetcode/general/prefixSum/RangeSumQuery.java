package com.leetcode.general.prefixSum;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/range-sum-query-immutable/description/", problemNumber = "303", solutionLink = "https://algo.monster/liteproblems/303")
public class RangeSumQuery {

    /**
     * This class efficiently answers multiple range sum queries on an integer array.
     * It uses prefix sum to preprocess cumulative sums so that each query is answered in O(1) time.
     */
    class NumArray {
        // Array to store prefix sums. prefixSums[i] holds sum of elements from index 0 to i.
        private final int[] prefixSums;

        /**
         * Constructs the NumArray object and precomputes the prefix sums.
         *
         * @param nums the input array of integers.
         *             Constraint: nums.length >= 1, values can be negative.
         */
        public NumArray(int[] nums) {
            this.prefixSums = new int[nums.length];
            prefixSums[0] = nums[0]; // initialize the first element
            for (int i = 1; i < nums.length; i++) {
                // each prefix sum is sum of previous prefix and current number
                prefixSums[i] = prefixSums[i - 1] + nums[i];
            }
        }

        /**
         * Returns the sum of elements between indices left and right inclusive.
         *
         * @param left  the starting index of the range.
         * @param right the ending index of the range.
         * @return the sum of elements from nums[left] to nums[right].
         *         If left == 0, return prefixSums[right] directly.
         */
        public int sumRange(int left, int right) {
            // If range starts from 0, directly return prefix sum till right
            if (left == 0) {
                return prefixSums[right];
            }
            // Else subtract prefix sum till (left - 1) to get the range sum
            return prefixSums[right] - prefixSums[left - 1];
        }
    }
}