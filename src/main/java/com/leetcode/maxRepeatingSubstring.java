package com.leetcode;

public class maxRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        String subsequence = word;
        int maxRep = 0;
        while (subsequence.length() <= sequence.length()) {
            if (sequence.contains(subsequence)) {
                maxRep++;
                subsequence += word;
            }
            else break;
        }
        return maxRep;
    }
}
