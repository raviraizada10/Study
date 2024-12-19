package com.leetcode;

//https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/
//1760
public class MinimumLimitOfBalls {
    public int minimumSize(int[] nums, int maxOperations) {
        // Binary search for the minimum possible penalty (maximum bag size)
        int low = 1, high = 0;

        // Determine the initial high value (the largest bag size in the array)
        for (int num : nums) {
            high = Math.max(high, num);
        }

        // Binary search for the minimum possible max bag size
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canAchieveMaxSize(nums, maxOperations, mid)) {
                high = mid;  // If mid is achievable, try smaller values.
            }
            else {
                low = mid + 1;  // If mid is not achievable, try larger values.
            }
        }

        return low;  // low will be the minimum possible maximum size after the search.
    }

    // Helper function to check if a max size can be achieved within maxOperations splits.
    private boolean canAchieveMaxSize(int[] nums, int maxOperations, int maxSize) {
        int operationsNeeded = 0;

        // Calculate the number of splits required for each bag
        for (int num : nums) {
            if (num > maxSize) {
                // If num is greater than maxSize, we need to split it
                operationsNeeded += (num - 1) / maxSize;
            }
            // If operations exceed maxOperations, return false
            if (operationsNeeded > maxOperations) {
                return false;
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        MinimumLimitOfBalls sol = new MinimumLimitOfBalls();

        // Test case 1
        int[] nums1 = {9};
        int maxOperations1 = 2;
        System.out.println(sol.minimumSize(nums1, maxOperations1));  // Output: 3

        // Test case 2
        int[] nums2 = {2, 4, 8, 2};
        int maxOperations2 = 4;
        System.out.println(sol.minimumSize(nums2, maxOperations2));  // Output: 2
    }
}
