package com.leetcode.essential.seventyFive;

//https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
public class ReverseWords {
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
            result.append(words[i]) // Append each word to the result.
                  .append(" ");     // Add a space after each word.
        }

        // Return the final string, trimmed to remove the trailing space.
        return result
                .toString()
                .trim();
    }

}
