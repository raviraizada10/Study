package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Stack;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/valid-parentheses/description/", problemNumber = "20", solutionLink = "https://algo.monster/liteproblems/20")
public class ValidParenthesis {
    /**
     * Validates if the input string of parentheses is well-formed.
     * A string is considered valid if every opening bracket has a matching closing bracket
     * in the correct order and properly nested.
     *
     * @param s the input string consisting of '(', ')', '{', '}', '[' and ']'
     * @return true if the string is valid; false otherwise
     *
     * Edge Cases:
     * - An empty string is valid.
     * - A string with only closing brackets or mismatched pairs is invalid.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (char currentChar : s.toCharArray()) {
            // If it's an opening bracket, push it to the stack
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                // If there's no corresponding opening bracket
                if (stack.isEmpty()) return false;

                // Pop the last opening bracket and check if it matches the closing one
                char lastOpenBracket = stack.pop();
                if (currentChar == ')' && lastOpenBracket != '(') return false;
                if (currentChar == '}' && lastOpenBracket != '{') return false;
                if (currentChar == ']' && lastOpenBracket != '[') return false;
            }
        }

        // If the stack is empty, all brackets matched; otherwise, it's invalid
        return stack.isEmpty();
    }
}