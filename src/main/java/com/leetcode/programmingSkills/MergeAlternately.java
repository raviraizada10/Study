package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/merge-strings-alternately/description/", problemNumber = "1768", solutionLink = "https://algo.monster/liteproblems/1768")
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) result.append(word1.charAt(i++));
            if (j < word2.length()) result.append(word2.charAt(j++));
        }
        return result.toString();
    }
}   