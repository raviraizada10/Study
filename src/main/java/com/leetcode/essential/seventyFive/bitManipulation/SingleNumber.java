package com.leetcode.essential.seventyFive.bitManipulation;

//https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=leetcode-75
//https://algo.monster/liteproblems/136
public class SingleNumber {
    /**
     * Finds the single number in an array of integers where every other element appears twice.
     *
     * @param nums An array of integers.
     * @return The single number in the array.
     */
    public int singleNumber(int[] nums) {
        // Initialize the result variable to 0. This will hold the final single number.
        var result = 0;

        // Iterate through each number in the array.
        for (int num : nums) {
            // XOR the current number with the result.
            // This cancels out numbers that appear in pairs, leaving only the single number.
            result ^= num;
        }

        // Return the single number found.
        return result;
    }

}
