package com.leetcode.potd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/string-matching-in-an-array/
//https://algo.monster/liteproblems/1408
public class StringMatching {
    /**
     * Finds all strings in the array that are substrings of another string.
     *
     * @param words The array of words.
     * @return A list of words that are substrings of another word in the list.
     */
    public List<String> stringMatching(String[] words) {
        // Set to hold the result to avoid duplicates
        Set<String> resultSet = new HashSet<>();

        // Iterate through each word in the array
        for (int i = 0; i < words.length; i++) {
            // Compare current word with all other words
            for (int j = 0; j < words.length; j++) {
                // Skip if it's the same word
                if (i != j) {
                    // If words[i] is a substring of words[j], add it to the result set
                    if (words[j].contains(words[i])) {
                        resultSet.add(words[i]);
                    }
                }
            }
        }

        // Convert the result set to a list and return it
        return new ArrayList<>(resultSet);
    }
}

