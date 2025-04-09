package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/", problemNumber = "2529", solutionLink = "https://algo.monster/liteproblems/2529")
public class MaxCountPositiveNegative {
    public int maximumCount(int[] nums) {
        var positive = 0;
        var negative = 0;
        for (int num : nums) {
            if (num > 0) positive++;
            else if (num < 0) negative++;
        }
        return Math.max(positive, negative);
    }
}   