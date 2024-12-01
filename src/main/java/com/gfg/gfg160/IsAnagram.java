package com.gfg.gfg160;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/anagram-1587115620
public class IsAnagram {
    public static boolean areAnagrams(String s1, String s2) {
        // Step 1: If the lengths are different, the strings cannot be anagrams
        if (s1.length() != s2.length()) return false;

        // Step 2: Initialize a frequency array for ASCII characters (size 128)
        // Each index represents a character, and its value represents the frequency.
        char[] freq = new char[128];

        // Step 3: Process both strings simultaneously
        for (int i = 0; i < s1.length(); i++) {
            // Increment frequency for the character from s1
            freq[s1.charAt(i)]++;
            // Decrement frequency for the character from s2
            freq[s2.charAt(i)]--;
        }

        // Step 4: Check if all frequencies are zero
        for (char c : freq) {
            // If any frequency is non-zero, s1 and s2 are not anagrams
            if (c != 0) return false;
        }

        // Step 5: All frequencies are zero, so the strings are anagrams
        return true;
    }
}
