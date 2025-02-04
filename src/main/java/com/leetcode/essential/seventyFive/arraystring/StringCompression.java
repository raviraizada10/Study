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
    public int compress(char[] chars) {
        int writeIndex = 0; // Index to write characters into the array
        int readIndex = 0;  // Index to read characters from the array

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count the occurrences of the current character
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the character to the array
            chars[writeIndex++] = currentChar;

            // If the count is greater than 1, write the count as digits
            if (count > 1) {
                for (char digit : Integer
                        .toString(count)
                        .toCharArray()) {
                    chars[writeIndex++] = digit;
                }
            }
        }
        return writeIndex;
    }

}
