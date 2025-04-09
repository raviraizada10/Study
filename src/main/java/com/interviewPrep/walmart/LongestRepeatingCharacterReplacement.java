package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/longest-repeating-character-replacement/description/", problemNumber = "424", solutionLink = "https://algo.monster/liteproblems/424")
public class LongestRepeatingCharacterReplacement {
    /**
     * Finds the length of the longest substring where at most k characters can be replaced
     * to make all characters the same. Uses a sliding window and character frequency tracking.
     *
     * @param s the input string consisting of uppercase English letters
     * @param k the maximum number of characters allowed to be replaced
     * @return the length of the longest valid substring
     *
     * Edge Cases:
     * - If the string is empty, returns 0.
     * - If k >= length of the string, the entire string can be made uniform.
     */
    public int characterReplacement(String s, int k) {
        int[] charFrequency = new int[26];
        int windowStart = 0, maxCharCount = 0, maxWindowLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);
            charFrequency[currentChar - 'A']++;
            maxCharCount = Math.max(maxCharCount, charFrequency[currentChar - 'A']);

            // If we need to replace more than k characters, shrink the window
            while ((windowEnd - windowStart + 1) - maxCharCount > k) {
                charFrequency[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }

            // Update maximum window size found so far
            maxWindowLength = Math.max(maxWindowLength, windowEnd - windowStart + 1);
        }

        return maxWindowLength;
    }
}