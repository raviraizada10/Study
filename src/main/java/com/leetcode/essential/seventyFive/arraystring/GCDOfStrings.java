package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.MATH;
import static com.customannotation.enums.ProblemTag.STRING;

@DifficultyLevel(EASY)
@ProblemCategory({MATH, STRING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/greatest-common-divisor-of-strings/description/", problemNumber = "1071", solutionLink = "https://algo.monster/liteproblems/1071")
public class GCDOfStrings {
    /**
     * Finds the greatest common divisor (GCD) of the lengths of two strings and returns the substring of str1 up to that length.
     * The GCD of two numbers helps determine the maximum length of a common substring that divides both strings evenly.
     *
     * @param str1 The first input string.
     * @param str2 The second input string.
     * @return The greatest common divisor substring of str1 and str2; empty string ("") if no such substring exists.
     * <p>
     * Edge Cases:
     * - If the concatenation of str1 and str2 is not equal to the concatenation of str2 and str1, returns an empty string.
     * - Works correctly for strings of different lengths.
     * - Handles cases where no common divisor substring exists.
     */
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 + str2 is equal to str2 + str1 to ensure they share a common prefix
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Calculate the greatest common divisor (GCD) of the lengths of str1 and str2
        int length = gcd(str1.length(), str2.length());

        // Return the substring of str1 from index 0 to length (exclusive)
        return str1.substring(0, length);
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using Euclid's algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The greatest common divisor of a and b.
     */
    private int gcd(int a, int b) {
        // Base case: If b is 0, return a (since the GCD of a and 0 is a)
        return b == 0 ? a : gcd(b, a % b);
    }

}
