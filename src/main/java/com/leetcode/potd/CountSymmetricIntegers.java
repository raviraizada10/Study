package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-symmetric-integers/description/", problemNumber = "2843", solutionLink = "https://algo.monster/liteproblems/2843")
public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            count += isSymmetric(num);
        }
        return count;
    }

    private int isSymmetric(int num) {
        String numStr = Integer.toString(num);
        int length = numStr.length();
        if (length % 2 == 1) {
            return 0;
        }
        int firstHalfSum = 0, secondHalfSum = 0;

        for (int i = 0; i < length / 2; ++i) {
            firstHalfSum += numStr.charAt(i) - '0';
        }
        for (int i = length / 2; i < length; ++i) {
            secondHalfSum += numStr.charAt(i) - '0';
        }
        return firstHalfSum == secondHalfSum ? 1 : 0;
    }
}   