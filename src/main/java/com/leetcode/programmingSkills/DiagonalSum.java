package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.MATRIX;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY, MATRIX})
@ProblemInfo(problemLink = "https://leetcode.com/problems/matrix-diagonal-sum/description/", problemNumber = "1572", solutionLink = "https://algo.monster/liteproblems/1572")
public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }
        return sum;
    }
}   