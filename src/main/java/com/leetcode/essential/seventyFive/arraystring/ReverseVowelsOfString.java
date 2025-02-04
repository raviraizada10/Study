package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.STRING;
import static com.customannotation.enums.ProblemTag.TWO_POINTERS;

@DifficultyLevel(EASY)
@ProblemCategory({STRING, TWO_POINTERS})
@ProblemInfo(problemLink = "https://leetcode.com/problems/reverse-vowels-of-a-string/description/", problemNumber = "345", solutionLink = "https://algo.monster/liteproblems/345")
public class ReverseVowelsOfString {
    /**
     * Swaps two characters in a char array.
     *
     * @param arr The char array in which to swap characters.
     * @param i   Index of the first character to swap.
     * @param j   Index of the second character to swap.
     */
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Reverses the vowels in a given string while maintaining the positions of consonants and other characters.
     *
     * @param s The input string to reverse vowels in.
     * @return The string with vowels reversed.
     * <p>
     * Edge Cases:
     * - Handles strings with no vowels or only vowels correctly.
     * - Works for both lowercase and uppercase vowels.
     */
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU"; // Define vowels to check against
        char[] ch = s.toCharArray(); // Convert the string to a char array for mutability

        // Initialize two pointers, one starting from the beginning and the other from the end
        for (int i = 0, j = s.length() - 1; i < j; ) {
            // Check if the characters at the current pointers are vowels
            boolean isFirstVowel = vowels.indexOf(ch[i]) != -1;
            boolean isLastVowel = vowels.indexOf(ch[j]) != -1;

            // If both characters are vowels, swap them
            if (isFirstVowel && isLastVowel) {
                swap(ch, i, j);
                i++;
                j--;
            }
            else if (!isFirstVowel) {
                i++; // Move the left pointer right if the current character is not a vowel
            }
            else {
                j--; // Move the right pointer left if the current character is not a vowel
            }
        }

        return new String(ch); // Convert the char array back to a string and return
    }

}
