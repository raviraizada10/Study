package com.interviewPrep.walmart;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

    /**
     * Finds the length of the longest substring without repeating characters.
     * Uses a sliding window with a HashSet to maintain a window of unique characters.
     *
     * @param s the input string
     * @return the length of the longest substring without duplicates
     *
     * Edge Cases:
     * - If input string is empty, returns 0.
     * - If all characters are unique, returns the length of the string.
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        int windowStart = 0, maxLength = 0;

        // Expand the window with windowEnd
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // If duplicate found, shrink the window from the start
            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(s.charAt(windowStart));
                windowStart++;
            }

            // Add the current character and update maxLength
            uniqueChars.add(currentChar);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
