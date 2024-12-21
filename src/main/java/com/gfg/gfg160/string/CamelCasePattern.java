package com.gfg.gfg160.string;

import java.util.ArrayList;
import java.util.List;

public class CamelCasePattern {
    public List<String> camelCase(String[] arr, String pat) {
        ArrayList<String> results = new ArrayList<>();
        for (String word : arr) {
            if (isSubsequence(pat, extractUpperCase(word))) {
                results.add(word);
            }
        }
        return results;
    }

    private static boolean isSubsequence(String pattern, String sequence) {
        int i = 0, j = 0;

        // Use two pointers to match pattern and sequence
        while (i < pattern.length() && j < sequence.length()) {
            if (pattern.charAt(i) == sequence.charAt(j)) {
                i++; // Move to the next character in the pattern
            }
            j++; // Always move to the next character in the sequence
        }

        // If we've matched all characters of the pattern, it's a subsequence
        return i == pattern.length();
    }

    private static String extractUpperCase(String str) {
        StringBuilder upperCaseSequence = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCaseSequence.append(ch);
            }
        }
        return upperCaseSequence.toString();
    }
}
