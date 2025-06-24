package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/", problemNumber = "2900", solutionLink = "https://algo.monster/liteproblems/2900")
public class LongestUnequalSubsequence {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }
        return result;
    }
}   