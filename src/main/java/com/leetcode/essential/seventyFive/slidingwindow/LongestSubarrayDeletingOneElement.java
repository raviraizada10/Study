package com.leetcode.essential.seventyFive.slidingwindow;

//https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
//1493
public class LongestSubarrayDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int maxOnes = 0;
        int zeroes = 0; // Track the number of zeros in the current window
        for (int i = 0, j = 0; j < nums.length; j++) {
            // If we encounter a zero, increment zeroes count
            if (nums[j] == 0) {
                zeroes++;
            }

            // If there are more than 1 zero in the window, shrink from the left
            while (zeroes > 1) {
                if (nums[i] == 0) {
                    zeroes--;
                }
                i++; // Move the left pointer forward to shrink the window
            }

            // Update maxOnes by comparing with the size of the current window
            maxOnes = Math.max(maxOnes, j - i + 1);
        }

        // Since we must delete one element, we subtract 1 from the result
        return maxOnes - 1;
    }

}
