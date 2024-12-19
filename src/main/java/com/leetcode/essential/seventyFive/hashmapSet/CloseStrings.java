package com.leetcode.essential.seventyFive.hashmapSet;

import java.util.*;

//https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        // Step 1: Check if the lengths of the two strings are equal.
        // If they aren't, they cannot be close, so return false.
        if (word1.length() != word2.length()) return false;

        // Step 2: Create frequency maps for both strings
        // freq1 will store the frequency of characters in word1
        // freq2 will store the frequency of characters in word2
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        // Populate the frequency map for word1
        for (char c : word1.toCharArray()) {
            // For each character, increment its count in freq1
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        // Populate the frequency map for word2
        for (char c : word2.toCharArray()) {
            // For each character, increment its count in freq2
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        // Step 3: Check if the unique character sets in both strings are the same
        // If the sets of characters are different, return false
        // This ensures that both strings contain the same unique characters
        if (!freq1.keySet().equals(freq2.keySet())) return false;

        // Step 4: Compare the frequencies of the characters in both strings
        // Create two lists to store the frequency values from the frequency maps
        List<Integer> freqList1 = new ArrayList<>(freq1.values());
        List<Integer> freqList2 = new ArrayList<>(freq2.values());

        // Sort both lists so we can compare the frequency counts
        Collections.sort(freqList1);
        Collections.sort(freqList2);

        // Step 5: Check if the sorted frequency lists are equal
        // If they are the same, return true, meaning the strings are close
        return freqList1.equals(freqList2);
    }

}
