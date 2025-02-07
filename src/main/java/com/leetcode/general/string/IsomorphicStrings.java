package com.leetcode.general.string;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.HASH_TABLE;
import static com.customannotation.enums.ProblemTag.STRING;

@DifficultyLevel(EASY)
@ProblemCategory({STRING, HASH_TABLE})
@ProblemInfo(problemLink = "https://leetcode.com/problems/isomorphic-strings/description/", problemNumber = "205", solutionLink = "https://algo.monster/liteproblems/205")
public class IsomorphicStrings {
    /**
     * Determines whether two given strings are isomorphic.
     * <p>
     * Two strings are isomorphic if there is a one-to-one character mapping
     * between them, meaning every character in the first string maps to a
     * unique character in the second string while maintaining the order.
     * </p>
     *
     * @param s The first input string.
     * @param t The second input string.
     * @return {@code true} if the strings are isomorphic, otherwise {@code false}.
     * <p>
     * Edge Cases:
     * - If `s` and `t` have different lengths, they cannot be isomorphic.
     * - If both strings are empty, they are trivially isomorphic.
     * - The function correctly handles cases where characters repeat.
     */
    public boolean isIsomorphic(String s, String t) {
        // If lengths differ, they can't be isomorphic
        if (s.length() != t.length()) return false;

        // Arrays to track the last seen positions of each character
        int[] sMapping = new int[256]; // Mapping for characters in s
        int[] tMapping = new int[256]; // Mapping for characters in t

        // Iterate through the characters of both strings
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If the previously stored index does not match, it means the mapping is inconsistent
            if (sMapping[sChar] != tMapping[tChar]) return false;

            // Store the current index (incremented by 1 to distinguish from default 0)
            sMapping[sChar] = i + 1;
            tMapping[tChar] = i + 1;
        }

        // If we reach here, the strings are isomorphic
        return true;
    }

}   