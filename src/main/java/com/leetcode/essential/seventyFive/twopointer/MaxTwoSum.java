package com.leetcode.essential.seventyFive.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
public class MaxTwoSum {
    public int maxOperations(int[] nums, int k) {
        // Sort the array to enable the two-pointer technique
        // Sorting takes O(n log n) time
        Arrays.sort(nums);

        // Variable to count the number of operations performed
        int maxOps = 0;

        // Two pointers: 'left' starts at the beginning, 'right' starts at the end of the array
        int left = 0, right = nums.length - 1;

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the sum of the current pair of elements
            int sum = nums[left] + nums[right];

            // If the sum equals k, we have found a valid pair
            if (sum == k) {
                maxOps++; // Increment the count of operations
                left++;   // Move the left pointer forward
                right--;  // Move the right pointer backward
            }
            // If the sum is less than k, move the left pointer to the right
            // to increase the sum
            else if (sum < k) {
                left++;
            }
            // If the sum is greater than k, move the right pointer to the left
            // to decrease the sum
            else {
                right--;
            }
        }

        // Return the total number of operations
        return maxOps;

    }
}
