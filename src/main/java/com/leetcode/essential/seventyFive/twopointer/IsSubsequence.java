package com.leetcode.essential.seventyFive.twopointer;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        // An empty string is always a subsequence of any string
        if (s.isEmpty())
            return true;

        // If `s` is longer than `t`, it cannot be a subsequence
        if (s.length() > t.length())
            return false;

        int i = 0, j = 0;

        // Use two pointers to compare characters
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                // If we've matched all characters of `s`, return true
                if (i == s.length()) {
                    return true;
                }
            }
            j++;
        }

        // If not all characters of `s` are matched, return false
        return false;
    }
}
