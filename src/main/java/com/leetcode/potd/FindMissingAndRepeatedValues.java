package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashSet;
import java.util.Set;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-missing-and-repeated-values/description/", problemNumber = "2965", solutionLink = "https://algo.monster/liteproblems/2965")
public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> numSet = new HashSet<>();
        int n = grid.length;
        int[] result =new int[2];
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (!numSet.add(ints[j])) {
                    result[1] = ints[j];
                }
            }
        }

        for (int i = 0; i <= n * n; i++) {
            if(!numSet.contains(i)) result[0] = i;
        }

        return result;
    }
}   