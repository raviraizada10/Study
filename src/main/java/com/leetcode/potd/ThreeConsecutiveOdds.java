package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/three-consecutive-odds/", problemNumber = "1550", solutionLink = "https://algo.monster/liteproblems/1550")
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) return true;
        }
        return false;
    }
}   