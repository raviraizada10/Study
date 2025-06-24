package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/number-of-equivalent-domino-pairs/", problemNumber = "1128", solutionLink = "https://algo.monster/liteproblems/1128")
public class NumberOfEquivalentDominos {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int numberOfPairs = 0;
        for (int[] domino : dominoes) {
            int lesserValue = Math.min(domino[0], domino[1]);
            int greaterValue = Math.max(domino[0], domino[1]);

            int normalizedDomino = lesserValue * 10 + greaterValue;
            numberOfPairs += count[normalizedDomino]++;
        }
        return numberOfPairs;
    }
}   