package com.leetcode.essential.seventyFive.arraystring;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        // Edge case: If the array has fewer than 3 elements, return false.
        if (nums.length < 3) {
            return false;
        }

        // Initialize two variables to track the smallest and the second smallest values.
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        // Traverse through the array.
        for (int num : nums) {
            // If the current number is smaller than or equal to the smallest, update `first`.
            if (num <= first) {
                first = num;
            }
            // If the current number is greater than `first` but smaller than or equal to `second`, update `second`.
            else if (num <= second) {
                second = num;
            }
            // If the current number is greater than both `first` and `second`, return true.
            else {
                return true;
            }
        }

        // If no such triplet is found, return false.
        return false;
    }

}
