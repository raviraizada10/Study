package com.leetcode.general.string;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.STRING;
import static com.customannotation.enums.ProblemTag.TRIE;

@DifficultyLevel(EASY)
@ProblemCategory({STRING, TRIE})
@ProblemInfo(problemLink = "https://leetcode.com/problems/longest-common-prefix/description/", problemNumber = "14", solutionLink = "https://algo.monster/liteproblems/14")
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) return "";
        }
        return prefix;
    }
}   