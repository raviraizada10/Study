package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-the-punishment-number-of-an-integer/", problemNumber = "2698", solutionLink = "https://algo.monster/liteproblems/2698")
public class PunishmentNumber {
    public int punishmentNumber(int n) {
        int punishSum = 0;
        for (int i = 0; i < n; i++) {
            var numSquare = i * i;
            if(i == sumOfDigits(numSquare)){
                punishSum += numSquare;
            }
        }
        return punishSum;
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