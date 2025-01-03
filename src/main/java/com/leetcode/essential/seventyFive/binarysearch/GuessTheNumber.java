package com.leetcode.essential.seventyFive.binarysearch;

import java.util.Random;

public class GuessTheNumber {
    /**
     * Uses binary search to find the guessed number.
     *
     * @param n The range of numbers (1 to n) within which the target number lies.
     * @return The number guessed correctly or -1 if not found.
     */
    public int guessNumber(int n) {
        // Define the search range.
        int left = 0, right = n;

        // Perform binary search to narrow down the guessed number.
        while (left <= right) {
            // Calculate the mid-point to guess.
            int mid = left + (right - left) / 2;

            // Call the `guess` API to check if the mid-point is correct.
            int result = guess(mid);

            // If the guess is correct, return the number.
            if (result == 0) return mid;

                // If the guess is too high, adjust the search range to the left half.
            else if (result == -1) right = mid - 1;

                // If the guess is too low, adjust the search range to the right half.
            else left = mid + 1;
        }

        // If the loop ends without finding the number, return -1.
        return -1;
    }

    /**
     * Simulates the `guess` API. It returns:
     * - 0 if the guessed number is correct.
     * - -1 if the guessed number is higher than the target.
     * - 1 if the guessed number is lower than the target.
     *
     * @param num The number guessed.
     * @return -1, 0, or 1 based on the comparison with the target.
     */
    int guess(int num) {
        // Randomly simulate the behavior of the `guess` API.
        Random random = new Random();

        // Randomly return -1, 0, or 1 to simulate the target comparison.
        return random.nextInt(3) - 1; // Randomly generates -1, 0, or 1.
    }
}
