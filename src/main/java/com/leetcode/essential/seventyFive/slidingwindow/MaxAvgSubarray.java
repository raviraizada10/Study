package com.leetcode.essential.seventyFive.slidingwindow;

//https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
public class MaxAvgSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // Calculate the initial window sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Set initial maxAvg to the average of the first window
        double maxAvg = sum / k;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Add the next element and remove the first element of the current window
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }
}
