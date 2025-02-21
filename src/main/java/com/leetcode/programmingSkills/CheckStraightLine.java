package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY, MATH, GEOMETRY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/check-if-it-is-a-straight-line/", problemNumber = "1232", solutionLink = "https://algo.monster/liteproblems/1232")
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (dy * (x - x0) != dx * (y - y0)) return false;
        }
        return true;
    }
}   