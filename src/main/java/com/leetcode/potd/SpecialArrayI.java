package com.leetcode.potd;

//https://leetcode.com/problems/special-array-i/description/
//3151
//https://algo.monster/liteproblems/3151
public class SpecialArrayI {
    /**
     * Determines if the given array follows a "special" alternating pattern.
     * A special array is one where no two consecutive elements are both even or both odd.
     *
     * @param nums The input array of integers.
     * @return true if the array follows the alternating pattern, false otherwise.
     * <p>
     * Edge Cases:
     * - A single-element array is always considered special.
     * - The function assumes that the input array is non-empty.
     */
    public boolean isArraySpecial(int[] nums) {
        // A single-element array is automatically special
        if (nums.length == 1) {
            return true;
        }

        // Iterate through the array from the second element onward
        for (int currentIndex = 1; currentIndex < nums.length; currentIndex++) {
            int currentNumber = nums[currentIndex];
            int previousNumber = nums[currentIndex - 1];

            // Check if both numbers are even or both are odd
            if ((currentNumber % 2 == 0 && previousNumber % 2 == 0) ||
                    (currentNumber % 2 != 0 && previousNumber % 2 != 0)) {
                return false; // Not alternating, return false immediately
            }
        }

        // If all pairs satisfy the alternating pattern, return true
        return true;
    }
}
