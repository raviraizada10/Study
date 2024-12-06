package com.leetcode.essential.seventyFive.slidingwindow;

import java.util.Set;

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
public class MaximumVowels {
    public int maxVowels(String s, int k) {
        int currVowels = 0; // Tracks the count of vowels in the current sliding window

        // Set containing vowels for quick lookup
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Initialize the count of vowels for the first window of size k
        for (int index = 0; index < k; index++) {
            if (vowels.contains(s.charAt(index))) { // Check if the character is a vowel
                currVowels++; // Increment the count if it's a vowel
            }
        }

        // Track the maximum number of vowels in any window
        int maxVowels = currVowels;

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Add the new character entering the window
            if (vowels.contains(s.charAt(i))) {
                currVowels++; // Increment count if it's a vowel
            }
            // Remove the character that is sliding out of the window
            if (vowels.contains(s.charAt(i - k))) {
                currVowels--; // Decrement count if it was a vowel
            }
            // Update the maximum vowel count if the current window has more vowels
            maxVowels = Math.max(maxVowels, currVowels);
        }

        // Return the maximum number of vowels found in any window
        return maxVowels;
    }


    public int maxVowelsUsingBinaryArray(String s, int k) {
        int currVowels = 0; // Tracks the count of vowels in the current sliding window
        int maxVowels = 0;  // Tracks the maximum number of vowels encountered in any window

        // Boolean array to mark vowels for quick lookup
        boolean[] isVowel = new boolean[256]; // 256 to cover all ASCII characters
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel[s.charAt(i)]) { // Check if the character is a vowel
                currVowels++;
            }
        }
        maxVowels = currVowels; // Set maxVowels to the count of vowels in the first window

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Add the new character at the end of the window
            if (isVowel[s.charAt(i)]) {
                currVowels++;
            }
            // Remove the character that is sliding out of the window
            if (isVowel[s.charAt(i - k)]) {
                currVowels--;
            }
            // Update the maximum vowel count if the current window has more vowels
            maxVowels = Math.max(maxVowels, currVowels);
        }

        return maxVowels; // Return the maximum number of vowels found in any window
    }

}
