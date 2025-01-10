package com.gfg.gfg160;

public class KadnesAlgorithm {
    /**
     * This method finds the maximum sum of a contiguous subarray within the given array using Kadane's Algorithm.
     *
     * @param arr The input array of integers, which may contain positive, negative, or zero values.
     * @return The maximum sum of any contiguous subarray in the array.
     *
     * <p>
     * The algorithm uses a dynamic programming approach where we calculate the running sum of subarrays and reset
     * it whenever it becomes less than the current element, ensuring we always consider the largest sum.
     * </p>
     *
     * <p>Time Complexity: O(n) - We traverse the array once.</p>
     * <p>Space Complexity: O(1) - No additional data structures are used.</p>
     */
    public int maxSubarraySum(int[] arr) {
        // Variable to track the current running sum of the subarray
        int currentSum = 0;

        // Variable to track the maximum sum found so far
        // Initialized to Integer.MIN_VALUE to handle cases where all elements are negative
        int maxSum = Integer.MIN_VALUE;

        // Iterate through each element in the array
        for (int num : arr) {
            // Update the current running sum
            // Choose between starting a new subarray with the current number
            // or extending the previous subarray
            currentSum = Math.max(num, currentSum + num);

            // Update the maximum sum found so far
            // Choose the larger value between the current maxSum and the currentSum
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum sum of a contiguous subarray
        return maxSum;
    }
}
