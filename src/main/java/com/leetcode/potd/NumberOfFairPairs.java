package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-the-number-of-fair-pairs/description/", problemNumber = "2563", solutionLink = "https://algo.monster/liteproblems/2563")
public class NumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            var left = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            var right = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            count += (right - left);
        }
        return count;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }


    private int upperBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
