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
@ProblemInfo(problemLink = "https://leetcode.com/problems/palindrome-partitioning/", problemNumber = "131", solutionLink = "https://algo.monster/liteproblems/131")
public class PalindromePartitioning {

    /**
     * 📝 Palindrome Partitioning – Backtracking
     * Recursively build partitions by choosing substrings that are palindromes.
     * At each step, if the chosen substring is a palindrome, add it to the current path and explore the rest of the string.
     * Backtrack by removing the last added substring to try other possibilities.
     * Repeat until the entire string is consumed and store the valid paths.
     **/
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, ArrayList<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result);
                path.remove(path.size() - 1);
            }

        }
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}   