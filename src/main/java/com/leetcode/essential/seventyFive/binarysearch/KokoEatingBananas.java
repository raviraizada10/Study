package com.leetcode.essential.seventyFive.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
    /**
     * Finds the minimum eating speed (k) such that Koko can finish all the bananas within h hours.
     *
     * @param piles An array representing the number of bananas in each pile.
     * @param h     The total number of hours available to eat all the bananas.
     * @return The minimum integer k representing Koko's eating speed.
     */
    public int minEatingSpeed(int[] piles, int h) {
        // The minimum possible speed is 1 banana per hour.
        int left = 1;

        // The maximum possible speed is the largest pile size (if Koko eats a pile in 1 hour).
        int right = Arrays
                .stream(piles)
                .max()
                .getAsInt();

        // Perform binary search to find the minimum valid eating speed.
        while (left < right) {
            // Calculate the middle speed to test.
            int mid = left + (right - left) / 2;

            // Check if Koko can finish all piles within h hours at the current speed.
            if (canEat(piles, mid, h)) {
                // If she can, try a slower speed (reduce the upper bound).
                right = mid;
            }
            else {
                // If she can't, increase the speed (increase the lower bound).
                left = mid + 1;
            }
        }

        // After the loop, left will hold the minimum valid speed.
        return left;
    }

    /**
     * Checks if Koko can eat all bananas within h hours at a given speed.
     *
     * @param piles An array representing the number of bananas in each pile.
     * @param mid   The current eating speed being tested.
     * @param h     The total number of hours available.
     * @return True if Koko can eat all bananas within h hours, otherwise false.
     */
    private boolean canEat(int[] piles, int mid, int h) {
        int totalHours = 0;

        // Iterate through each pile to calculate the total hours needed at the current speed.
        for (int pile : piles) {
            // Compute the number of hours required for the current pile using ceiling division.
            // (pile + mid - 1) / mid computes the ceiling of pile / mid.
            totalHours += (pile + mid - 1) / mid;

            // Early exit: if totalHours already exceeds h, no need to continue checking.
            if (totalHours > h) {
                return false;
            }
        }

        // Return true if the total hours required is within the allowed time.
        return totalHours <= h;
    }
}
