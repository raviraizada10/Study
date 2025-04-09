package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.STRING;
import static com.customannotation.enums.ProblemTag.TWO_POINTERS;

@DifficultyLevel(MEDIUM)
@ProblemCategory({STRING, TWO_POINTERS})
@ProblemInfo(problemLink = "https://leetcode.com/problems/string-compression/description/", problemNumber = "443", solutionLink = "https://algo.monster/liteproblems/443")
public class StringCompression {
    /**
     * Compresses the input character array in-place using the run-length encoding format.
     * For example, the array ['a','a','b','b','c','c','c'] becomes ['a','2','b','2','c','3'].
     *
     * @param chars The input character array to be compressed.
     *              Must be a non-null array with at least one element.
     * @return The new length of the array after compression.
     *         Only the first returnedLength characters should be considered valid.
     *
     * Edge Cases:
     * - If all characters are unique, the array remains unchanged and returnedLength == chars.length.
     * - If all characters are the same, they will be compressed into char + count (e.g., 'a' x 12 -> ['a','1','2']).
     */
    public int compress(char[] chars) {
        int writer = 0; // Pointer to write characters in-place into the array
        int reader = 0; // Pointer to read characters from the original array

        while (reader < chars.length) {
            char currentCharacter = chars[reader]; // Store the character to compress
            int frequency = 0; // Track frequency of the current character

            // Count how many times the current character repeats consecutively
            while (reader < chars.length && chars[reader] == currentCharacter) {
                reader++;
                frequency++;
            }

            // Write the character once
            chars[writer++] = currentCharacter;

            // If the character repeats more than once, write its count as individual digits
            if (frequency > 1) {
                for (char digit : Integer.toString(frequency).toCharArray()) {
                    chars[writer++] = digit;
                }
            }
        }

        // Return the length of the compressed array
        return writer;
    }

}
