package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/", problemNumber = "2894", solutionLink = "https://algo.monster/liteproblems/2894")
public class DivisibleNonDivisibleDifference {
    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0)
                num1 += i;
            else
                num2 += i;
        }
        return num1 - num2;
    }
}   