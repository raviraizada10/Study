package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/", problemNumber = "1295", solutionLink = "https://algo.monster/liteproblems/1295")
public class EvenNumbersInDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = 0;
            while (num >= 1) {
                num /= 10;
                digits++;
            }
            if (digits % 2 == 0) count++;
        }
        return count;
    }
}   