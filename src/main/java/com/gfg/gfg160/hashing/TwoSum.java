package com.gfg.gfg160.hashing;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    boolean twoSum(int arr[], int target) {
        // Step 1: Initialize a HashSet to store numbers we've seen so far
        Set<Integer> sumSet = new HashSet<>();

        // Step 2: Iterate through the array
        for (int j : arr) {
            // Calculate the complement needed to form the target sum
            int complement = target - j;

            // Step 3: Check if the complement exists in the set
            if (sumSet.contains(complement)) {
                return true; // If found, return true as a pair exists
            }
            else {
                // Otherwise, add the current number to the set
                sumSet.add(j);
            }
        }

        // Step 4: If no such pair is found, return false
        return false;
    }
}
