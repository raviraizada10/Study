package com.gfg.gfg160.hashing;

import java.util.HashMap;

public class SubarrayWithXor {
    /**
     * Finds the count of subarrays with XOR equal to k.
     *
     * @param arr The input array of integers.
     * @param k   The target XOR value.
     * @return The count of subarrays with XOR equal to k.
     */
    public static long subarrayXor(int[] arr, int k) {
        long countSubarrays = 0; // Initialize the count of subarrays
        HashMap<Integer, Integer> xorFrequencyMap = new HashMap<>(); // Map to store prefix XOR frequencies
        int currentPrefixXor = 0; // Tracks the current prefix XOR

        for (int num : arr) {
            // Update the current prefix XOR
            currentPrefixXor ^= num;

            // Check if there exists a prefix XOR that satisfies the equation
            countSubarrays += xorFrequencyMap.getOrDefault(currentPrefixXor ^ k, 0);

            // If the current prefix XOR itself equals k, increment the count
            if (currentPrefixXor == k) {
                countSubarrays++;
            }

            // Update the frequency of the current prefix XOR in the map
            xorFrequencyMap.put(currentPrefixXor, xorFrequencyMap.getOrDefault(currentPrefixXor, 0) + 1);
        }

        return countSubarrays; // Return the total count of subarrays
    }
}
