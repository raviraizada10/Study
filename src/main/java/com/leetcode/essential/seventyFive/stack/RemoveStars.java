package com.leetcode.essential.seventyFive.stack;

import java.util.Stack;

//https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
//2390
public class RemoveStars {
    public String removeStars(String s) {
        // Initialize a StringBuilder to construct the result dynamically
        StringBuilder result = new StringBuilder();

        // Traverse the string character by character
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // If the current character is '*', remove the last character
                // from the result. The `deleteCharAt` method removes the character
                // at the specified index (last index in this case).
                result.deleteCharAt(result.length() - 1);
            }
            else {
                // If the current character is not '*', append it to the result
                result.append(ch);
            }
        }

        // Convert the StringBuilder to a string and return it as the final result
        return result.toString();
    }

    public String removeStarsStack(String s) {
        // Initialize a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Traverse the string character by character
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                // If the current character is a '*',
                // remove (pop) the most recently added character from the stack.
                // This simulates removing the closest non-star character to the left.
                stack.pop();
            }
            else {
                // If the current character is not a '*',
                // add (push) it to the stack.
                stack.push(ch);
            }
        }

        // Initialize a StringBuilder to construct the final result
        StringBuilder result = new StringBuilder();

        // Collect all characters remaining in the stack.
        // The stack preserves the correct order since it operates as LIFO (last-in, first-out).
        for (char ch : stack) {
            result.append(ch);
        }

        // Convert the StringBuilder to a string and return it.
        return result.toString();
    }
}
