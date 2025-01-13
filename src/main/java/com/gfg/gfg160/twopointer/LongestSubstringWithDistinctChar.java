package com.gfg.gfg160.twopointer;

import java.util.HashMap;

public class LongestSubstringWithDistinctChar {
    /**
     * Finds the length of the longest substring with all distinct characters.
     *
     * @param s Input string
     * @return Length of the longest substring with all distinct characters
     */
    public static int longestUniqueSubstr(String s) {
        // HashMap to store the last index of each character
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        int left = 0; // Start of the sliding window
        int maxLength = 0;

        // Iterate through the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and its index is within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // Move the left pointer to exclude the duplicate character
                left = charIndexMap.get(currentChar) + 1;
            }

            // Update the map with the current character's index
            charIndexMap.put(currentChar, right);

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
