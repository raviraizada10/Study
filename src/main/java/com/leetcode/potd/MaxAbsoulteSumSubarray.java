package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/", problemNumber = "1749", solutionLink = "https://algo.monster/liteproblems/1749")
public class MaxAbsoulteSumSubarray {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int currentMax = 0;
        int currentMin = 0;
        for (int num : nums) {
            currentMax = Math.max(currentMax + num, 0);
            currentMin = Math.min(currentMin + num, 0);
            maxSum = Math.max(maxSum, Math.max(Math.abs(currentMin), currentMax));
        }
        return maxSum;
    }
}   