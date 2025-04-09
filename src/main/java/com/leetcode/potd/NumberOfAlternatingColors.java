package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "http://leetcode.com/problems/alternating-groups-ii/description/", problemNumber = "", solutionLink = "https://algo.monster/liteproblems/")
public class NumberOfAlternatingColors {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int validPairs = 0;

        for (int i = 0; i < k - 1; i++) {
            int curr = colors[i % n];
            int next = colors[(i + 1) % n];
            if (curr != next) validPairs++;
        }

        if (validPairs == k - 1) count++;

        for (int i = 1; i < n; i++) {
            int out1 = colors[(i - 1) % n];
            int out2 = colors[(i) % n];
            if (out1 != out2) validPairs--;

            int in1 = colors[(i + k - 2) % n];
            int in2 = colors[(i + k - 1) % n];
            if (in1 != in2) validPairs++;

            if (validPairs == k - 1) count++;
        }

        return count;
    }
}   