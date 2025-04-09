package com.leetcode.essential.oneFifty.twopointer;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, TWO_POINTERS, BINARY_SEARCH})
@ProblemInfo(problemLink = "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/", problemNumber = "167", solutionLink = "https://algo.monster/liteproblems/167")
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            else if (sum < target) i++;
            else j--;
        }
        return new int[]{};
    }
}   