package com.leetcode.potd;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-01-04
//1930
//https://algo.monster/liteproblems/1930
public class UniqueLengthPalindromicSubsequence {
    public int countPalindromicSubsequence(String s) {
        var totalCount = 0;
        for (int ch = 'a'; ch <= 'z'; ch++) {
            var start = s.indexOf(ch);
            var end = s.lastIndexOf(ch);
            if (start == -1 || end == start) {
                continue;
            }
            var middleString = s.substring(start + 1, end);
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : middleString.toCharArray()) {
                uniqueChars.add(c);
            }
            totalCount += uniqueChars.size();
        }
        return totalCount;
    }
}
