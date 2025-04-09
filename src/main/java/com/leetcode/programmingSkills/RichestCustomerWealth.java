package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.MATRIX;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY, MATRIX})
@ProblemInfo(problemLink = "https://leetcode.com/problems/richest-customer-wealth/", problemNumber = "1672", solutionLink = "https://algo.monster/liteproblems/1672")
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int currentWealth = 0;
            for (int i : account) {
                currentWealth += i;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        return maxWealth;
    }
}   