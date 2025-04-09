package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.STRING;
import static com.customannotation.enums.ProblemTag.TWO_POINTERS;

@DifficultyLevel(EASY)
@ProblemCategory({STRING, TWO_POINTERS})
@ProblemInfo(problemLink = "https://leetcode.com/problems/merge-strings-alternately/description/", problemNumber = "1768", solutionLink = "https://algo.monster/liteproblems/1768")
public class MergeStringsAlternatively {
    /**
     * Merges two strings alternately, appending characters from each string until one or both strings are fully processed.
     *
     * @param word1 The first input string.
     * @param word2 The second input string.
     * @return A string resulting from merging characters alternately from word1 and word2.
     * <p>
     * Edge Cases:
     * - Handles strings of different lengths.
     * - Works correctly for empty strings or when one of the strings is empty.
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder(); // Initialize a StringBuilder to build the result

        int i = 0, j = 0; // Initialize indices for word1 and word2

        // Append characters alternately from both strings until both are fully processed
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length())
                result.append(word1.charAt(i++)); // Append character from word1 if it's within bounds
            if (j < word2.length())
                result.append(word2.charAt(j++)); // Append character from word2 if it's within bounds
        }

        return result.toString(); // Convert StringBuilder to String and return the merged result
    }

}
