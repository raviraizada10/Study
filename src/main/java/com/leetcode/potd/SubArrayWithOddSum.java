package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, MATH, DYNAMIC_PROGRAMMING, PREFIX_SUM})
@ProblemInfo(problemLink = "https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/", problemNumber = "1524", solutionLink = "https://algo.monster/liteproblems/1524")
public class SubArrayWithOddSum {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1, sum = 0, result = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            }
            else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        return result;
    }
}   