package com.leetcode.essential.seventyFive;

//https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        int len = Math.min(word1.length(), word2.length());
        while (i < len || j < len) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }
        if (word1.length() > len) {
            result.append(word1, len, word1.length());
        }
        if (word2.length() > len) {
            result.append(word2, len, word2.length());
        }
        return result.toString();
    }
}
