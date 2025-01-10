package com.leetcode.essential.seventyFive.dp.oneDimentional;

//https://leetcode.com/problems/house-robber/
//https://algo.monster/liteproblems/198
public class HouseRobber {
    /**
     * Solves the House Robber problem by finding the maximum amount of money
     * that can be robbed without robbing two adjacent houses.
     *
     * @param nums Array of integers where nums[i] represents the amount of money in the ith house.
     * @return Maximum amount of money that can be robbed without triggering alarms.
     */
    public int rob(int[] nums) {
        // Edge case: If there is only one house, return its value
        if (nums.length == 1)
            return nums[0];

        // Variables to keep track of the maximum profit at each step
        int previousRobbed = 0; // Maximum profit including the current house
        int previousNotRobbed = 0; // Maximum profit excluding the current house

        // Iterate through each house in the array
        for (int num : nums) {
            // Calculate the maximum profit for the current house
            int current = Math.max(previousRobbed, previousNotRobbed + num);

            // Update previousNotRobbed to the value of previousRobbed (skipping current house)
            previousNotRobbed = previousRobbed;

            // Update previousRobbed to the current maximum profit
            previousRobbed = current;
        }

        // Return the maximum profit at the end of the array
        return previousRobbed;
    }
}

