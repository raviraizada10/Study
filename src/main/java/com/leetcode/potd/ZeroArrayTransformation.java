package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/zero-array-transformation-i/", problemNumber = "3355", solutionLink = "https://algo.monster/liteproblems/3355")
public class ZeroArrayTransformation {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differenceArray = new int[n + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            ++differenceArray[left];
            --differenceArray[right + 1];
        }
        int currentSum = 0;
        for (int i = 0; i < n; ++i) {
            currentSum += differenceArray[i];
            if (nums[i] > currentSum) {
                return false;
            }
        }
        return true;
    }
}   