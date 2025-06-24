package com.leetcode.general.binarysearch;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.BINARY_SEARCH;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, BINARY_SEARCH})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/", problemNumber = "34", solutionLink = "https://algo.monster/liteproblems/34")
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if (nums.length == 0)
            return result;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (nums[mid - 1] == target) {
                    result[1] = mid;
                    right = mid - 1;
                } else {
                    result[0] = mid;
                    left = mid + 1;
                }
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return result;
    }
}   