package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/", problemNumber = "2342", solutionLink = "https://algo.monster/liteproblems/2342")
public class MaxSumWithEqualDigits {
    public int maximumSum(int[] nums){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = sumOfDigits(nums[i]);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0)+nums[i]);
            maxSum = Math.max(maxSum, sumMap.get(sum));
        }
        return maxSum;
    }

    static int sumOfDigits(int value) {
        int sum = 0;
        while (value != 0) {
            int last = value % 10;
            sum += last;
            value /= 10;
        }
        return sum;
    }
}   