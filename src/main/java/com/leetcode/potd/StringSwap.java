package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(EASY)
@ProblemCategory({HASH_TABLE, STRING, COUNTING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/", problemNumber = "1790", solutionLink = "https://algo.monster/liteproblems/1790")
public class StringSwap {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        var firstDifferent = -1;
        var secondDifferent = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstDifferent == -1) firstDifferent = i;
                else if (secondDifferent == -1) secondDifferent = i;
                else return false;
            }
        }
        return firstDifferent == -1 || (secondDifferent != -1
                && s1.charAt(firstDifferent) == s2.charAt(secondDifferent)
                && s1.charAt(secondDifferent) == s2.charAt(firstDifferent));
    }
}   