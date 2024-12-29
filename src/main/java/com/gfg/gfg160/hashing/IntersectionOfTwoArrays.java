package com.gfg.gfg160.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Step 1: Create a HashSet to store unique elements from the first array
        // A Set is used because it automatically handles duplicates and allows O(1) lookup
        Set<Integer> aSet = new HashSet<>();

        // Populate the HashSet with elements from array 'a'
        for (int element : a) {
            aSet.add(element); // Add each element of 'a' to the set
        }

        // Step 2: Create a result list to store the intersection of the two arrays
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through array 'b' to find common elements
        for (int element : b) {
            // Check if the current element of 'b' exists in the HashSet
            if (aSet.contains(element)) {
                result.add(element); // Add the common element to the result list
                aSet.remove(element); // Remove the element from the set to avoid duplicate additions
            }
        }

        // Step 3: Return the result list containing the intersection
        return result;
    }
}
