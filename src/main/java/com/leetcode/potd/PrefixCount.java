package com.leetcode.potd;

//https://leetcode.com/problems/counting-words-with-a-given-prefix/
//https://algo.monster/liteproblems/2185
public class PrefixCount {
    /**
     * Counts the number of words in the given array that start with the specified prefix.
     *
     * @param words An array of strings to search for the prefix.
     * @param pref  The prefix to check for in each word.
     * @return The count of words in the array that start with the given prefix.
     */
    public int prefixCount(String[] words, String pref) {
        // Initialize a counter to track the number of words starting with the prefix
        int count = 0;

        // Iterate over each word in the words array
        for (String word : words) {
            // Check if the current word starts with the given prefix
            if (word.startsWith(pref)) {
                // Increment the counter if the word starts with the prefix
                count++;
            }
        }

        // Return the total count of words starting with the prefix
        return count;
    }
}
