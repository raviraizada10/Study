package com.gfg.gfg160.hashing;

import java.util.*;

public class TripletsWithZeroSum {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Step 1: Create a set to store unique triplets (no duplicates allowed)
        Set<ArrayList<Integer>> uniqueTriplets = new HashSet<>();

        // Step 2: Initialize variables
        int arrayLength = arr.length; // Length of the input array

        // Step 3: Create a map to store pairs of elements and their sum
        // The key is the pair sum, and the value is a list of pairs of indices
        Map<Integer, List<int[]>> pairSumMap = new HashMap<>();

        // Step 4: Populate the pairSumMap with all pairs of elements
        for (int firstIndex = 0; firstIndex < arrayLength; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < arrayLength; secondIndex++) {
                int pairSum = arr[firstIndex] + arr[secondIndex]; // Calculate the sum of the pair

                // Add the pair of indices to the map
                pairSumMap
                        .computeIfAbsent(pairSum, k -> new ArrayList<>())
                        .add(new int[]{firstIndex, secondIndex});
            }
        }

        // Step 5: Find triplets by iterating through each element
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            int requiredSum = -arr[currentIndex]; // The sum needed to make the triplet sum to zero

            // Check if there are pairs in the map with the required sum
            if (pairSumMap.containsKey(requiredSum)) {
                List<int[]> matchingPairs = pairSumMap.get(requiredSum); // Get the list of matching pairs

                // Iterate through each pair
                for (int[] pairIndices : matchingPairs) {
                    // Ensure that the current index is not part of the pair
                    if (pairIndices[0] != currentIndex && pairIndices[1] != currentIndex) {
                        // Create a triplet using the indices
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(
                                arr[currentIndex], arr[pairIndices[0]], arr[pairIndices[1]]));

                        // Sort the triplet to avoid duplicate orderings
                        Collections.sort(triplet);

                        // Add the triplet to the set
                        uniqueTriplets.add(triplet);
                    }
                }
            }
        }

        // Step 6: Convert the set of unique triplets to a list and return
        return new ArrayList<>(uniqueTriplets);
    }
}
