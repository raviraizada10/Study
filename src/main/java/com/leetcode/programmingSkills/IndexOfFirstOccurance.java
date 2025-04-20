package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/", problemNumber = "28", solutionLink = "https://algo.monster/liteproblems/28")
public class IndexOfFirstOccurance {
    public int strStrEasy(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}   