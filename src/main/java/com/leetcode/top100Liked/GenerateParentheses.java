package com.leetcode.top100Liked;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/generate-parentheses/description/", problemNumber = "22", solutionLink = "https://algo.monster/liteproblems/22")
public class GenerateParentheses {
    List<String> result = new ArrayList<>();
    int maxPairs;

    public List<String> generateParenthesis(int n) {
        maxPairs = n;
        generate(0, 0, "");
        return result;
    }

    private void generate(int openCount, int closeCount, String currentString) {
        if (openCount > maxPairs || closeCount > maxPairs || openCount < closeCount) return;
        if (openCount == maxPairs && closeCount == maxPairs) {
            result.add(currentString);
            return;
        }
        generate(openCount + 1, closeCount, currentString + "(");
        generate(openCount, closeCount + 1, currentString + ")");
    }
}   