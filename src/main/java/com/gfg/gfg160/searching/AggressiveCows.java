package com.gfg.gfg160.searching;

import java.util.Arrays;

public class AggressiveCows {
    // Main function to find the largest minimum distance
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Step 1: Sort the stall positions

        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Midpoint of the search space

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result and search for a larger distance
                low = mid + 1;
            }
            else {
                high = mid - 1; // Search for a smaller distance
            }
        }

        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int minDist) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0]; // Position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i]; // Update the last cow's position
            }
            if (count >= k) return true; // All cows placed successfully
        }
        return false;
    }

}
