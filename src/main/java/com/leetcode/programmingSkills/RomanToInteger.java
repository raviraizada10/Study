package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Map;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(EASY)
@ProblemCategory({HASH_TABLE, MATH, STRING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/roman-to-integer/description/?envType=study-plan-v2&envId=programming-skills", problemNumber = "13", solutionLink = "https://algo.monster/liteproblems/13")
public class RomanToInteger {
    /**
     * Converts a Roman numeral string to its integer equivalent.
     *
     * <p>This method processes the Roman numeral from left to right,
     * adding values for normal cases and subtracting when a smaller numeral
     * appears before a larger numeral (e.g., IV = 4, IX = 9).</p>
     *
     * @param romanNumeral A valid Roman numeral string (1 <= s.length <= 15).
     *                     Contains only characters {'I', 'V', 'X', 'L', 'C', 'D', 'M'}.
     * @return The integer equivalent of the Roman numeral.
     * @throws NullPointerException     if input is null.
     * @throws IllegalArgumentException if input contains invalid characters.
     */
    public int romanToInt(String romanNumeral) {
        // Mapping of Roman numerals to their integer values
        Map<Character, Integer> romanToIntegerMap = Map.of(
                'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );

        int integerValue = 0;
        int length = romanNumeral.length();

        for (int i = 0; i < length; i++) {
            int currentValue = romanToIntegerMap.get(romanNumeral.charAt(i));

            // Check if the next character exists and is greater than the current one
            if (i < length - 1 && currentValue < romanToIntegerMap.get(romanNumeral.charAt(i + 1))) {
                integerValue -= currentValue; // Subtract for cases like IV, IX, etc.
            }
            else {
                integerValue += currentValue; // Otherwise, add normally
            }
        }

        return integerValue;
    }
}   