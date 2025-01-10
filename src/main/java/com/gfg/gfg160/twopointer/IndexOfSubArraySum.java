package com.gfg.gfg160.twopointer;

import java.util.ArrayList;

public class IndexOfSubArraySum {
    /**
     * Finds the first continuous subarray whose sum equals the target.
     *
     * @param arr    Array of non-negative integers.
     * @param target Target sum to find.
     * @return List containing 1-based indices of the subarray. If no such subarray exists, returns [-1].
     */
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int start = 0, end = 0;
        int currentSum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i]; // Add the current element to the window

            // If current sum is greater or equal to the target
            if (currentSum >= target) {
                end = i; // Update the end pointer

                // Shrink the window if the sum exceeds the target
                while (currentSum > target && start < end) {
                    currentSum -= arr[start];
                    start++;
                }

                // Check if we found a matching subarray
                if (currentSum == target) {
                    result.add(start + 1); // Convert to 1-based index
                    result.add(end + 1);
                    return result;
                }
            }
        }

        // If no valid subarray is found
        result.add(-1);
        return result;
    }
}
