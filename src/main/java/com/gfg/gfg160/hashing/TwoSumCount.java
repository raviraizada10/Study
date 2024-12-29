package com.gfg.gfg160.hashing;

import java.util.HashSet;
import java.util.Set;

public class TwoSumCount {
    int countPairs(int arr[], int target) {
        // Step 1: Initialize a HashSet to store numbers we've seen so far
        Set<Integer> sumSet = new HashSet<>();

        // Step 2: Initialize a counter to count valid pairs
        int count = 0;

        // Step 3: Iterate through the array
        for (int j : arr) {
            // Calculate the complement needed to form the target sum
            int complement = target - j;

            // Step 4: Check if the complement exists in the set
            if (sumSet.contains(complement)) {
                count++; // Increment the count if a pair is found
            }
            else {
                // Otherwise, add the current number to the set
                sumSet.add(j);
            }
        }

        // Step 5: Return the total count of pairs
        return count;
    }
}
