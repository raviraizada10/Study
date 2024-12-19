package com.leetcode.essential.seventyFive.prefixSum;

//https://leetcode.com/problems/find-pivot-index/submissions/1471877417/?envType=study-plan-v2&envId=leetcode-75
//724
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        // Step 1: Create leftSum and rightSum arrays
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        // Initialize the leftSum array
        leftSum[0] = 0; // There are no elements to the left of index 0
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1]; // Cumulative sum up to the previous element
        }

        // Initialize the rightSum array
        rightSum[n - 1] = 0; // There are no elements to the right of the last index
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1]; // Cumulative sum from the next element
        }

        // Step 2: Find the pivot index
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i; // Return the first pivot index
            }
        }

        // If no pivot index is found
        return -1;
    }

}
