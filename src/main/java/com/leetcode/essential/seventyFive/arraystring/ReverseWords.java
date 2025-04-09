package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.STRING;
import static com.customannotation.enums.ProblemTag.TWO_POINTERS;

@DifficultyLevel(MEDIUM)
@ProblemCategory({STRING, TWO_POINTERS})
@ProblemInfo(problemLink = "https://leetcode.com/problems/reverse-words-in-a-string/description/", problemNumber = "151", solutionLink = "https://algo.monster/liteproblems/151")
public class ReverseWords {
    /**
     * Reverses the words in a given string while preserving their order and handling spaces properly.
     *
     * @param s The input string to reverse words in.
     * @return The string with words reversed.
     * <p>
     * Edge Cases:
     * - Handles leading, trailing, and multiple spaces between words correctly.
     * - Works for strings with no words or a single word.
     */
    public String reverseWords(String s) {
        // Replace multiple spaces with a single space and remove leading/trailing spaces.
        s = s
                .replaceAll("\\s+", " ")
                .trim();

        // Split the string into an array of words using a single space as the delimiter.
        String[] words = s.split(" ");

        // Create a StringBuilder to store the reversed words.
        StringBuilder result = new StringBuilder();

        // Iterate through the words array in reverse order.
        for (int i = words.length - 1; i >= 0; i--) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(words[i]);
        }
        return result.toString();
    }
}
