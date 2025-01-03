package com.leetcode.essential.seventyFive.binarysearch;

import java.util.Arrays;

//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75
//2300
//https://algo.monster/liteproblems/2300
public class SuccessfulPotionSpellPairs {
    /**
     * Function to determine the number of successful pairs of spells and potions.
     *
     * @param spells           An array representing the power of spells.
     * @param potions          An array representing the power of potions.
     * @param successThreshold The minimum product required for a pair to be successful.
     * @return An array where each element represents the number of successful pairs for the corresponding spell.
     */
    public int[] successfulPairs(int[] spells, int[] potions, long successThreshold) {
        // Step 1: Sort the potions array to enable binary search.
        Arrays.sort(potions);

        // Step 2: Get the number of spells and initialize the result array.
        int nSpells = spells.length; // Number of spells.
        int[] successfulPairs = new int[nSpells]; // Result array.

        // Step 3: Iterate over each spell to calculate its successful pairs.
        for (int i = 0; i < nSpells; ++i) {
            // Find the first valid potion index using binary search.
            int index = binarySearchFirstValid(potions, spells[i], successThreshold);

            // Calculate the number of successful pairs for this spell.
            successfulPairs[i] = potions.length - index; // All potions from 'index' to the end are valid.
        }

        // Step 4: Return the result array.
        return successfulPairs;
    }

    /**
     * Helper function to find the smallest index where the product of the spell and potion
     * meets or exceeds the success threshold.
     *
     * @param potions          The sorted array of potions.
     * @param spell            The power of the current spell.
     * @param successThreshold The minimum product required for success.
     * @return The lowest index in potions where the condition is met.
     */
    private int binarySearchFirstValid(int[] potions, int spell, long successThreshold) {
        // Initialize binary search pointers.
        int left = 0, right = potions.length;

        // Perform binary search.
        while (left < right) {
            // Calculate the middle index.
            int mid = left + (right - left) / 2;

            // Check if the product of spell and potion meets the threshold.
            if ((long) spell * potions[mid] >= successThreshold) {
                right = mid; // If valid, search in the left half.
            }
            else {
                left = mid + 1; // Otherwise, search in the right half.
            }
        }

        // Return the lowest index where the condition is met.
        return left;
    }
}
