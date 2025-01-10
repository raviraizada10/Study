package com.leetcode.essential.seventyFive.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//https://algo.monster/liteproblems/17
public class LetterCombinations {
    // Mapping of digits to corresponding letters on a phone keypad
    private static final String[] DIGIT_TO_LETTER = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    /**
     * Generates all possible letter combinations that the input digits can represent.
     *
     * @param digits A string consisting of digits from 2 to 9 inclusive.
     * @return A list of all possible letter combinations in lexicographical order.
     * Returns an empty list if the input is null or empty.
     */
    public List<String> letterCombinations(String digits) {
        // Result list to store all possible combinations
        List<String> result = new ArrayList<>();

        // Handle edge case where input is null or empty
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Start backtracking to generate combinations
        backtrack(result, new StringBuilder(), digits, 0);

        return result;
    }

    /**
     * Helper method to perform backtracking and generate letter combinations.
     *
     * @param result  The list that stores all valid letter combinations.
     * @param current The current combination being built.
     * @param digits  The input string of digits.
     * @param index   The current index in the digits string being processed.
     */
    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: If the current combination's length equals the input length
        if (index == digits.length()) {
            // Add the complete combination to the result list
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = DIGIT_TO_LETTER[digits.charAt(index) - '0'];

        // Explore all possible letters for the current digit
        for (char letter : letters.toCharArray()) {
            // Choose: Add the letter to the current combination
            current.append(letter);

            // Explore: Move to the next digit
            backtrack(result, current, digits, index + 1);

            // Un-choose: Remove the last added letter to backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }

}
