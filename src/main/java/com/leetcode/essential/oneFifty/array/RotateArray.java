package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    /**
     * Rotates an array to the right by k positions using the reversal algorithm.
     * <p>
     * This method modifies the input array in-place to achieve the rotation
     * with O(n) time complexity and O(1) space complexity.
     *
     * @param nums the input array to rotate
     * @param k    the number of positions to rotate the array
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // Normalize k to handle cases where k > n
        k = k % n;
        if (k == 0) return; // No rotation needed if k is 0

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    /**
     * Helper method to reverse a portion of an array in-place.
     *
     * @param arr   the input array
     * @param left  the starting index of the portion to reverse
     * @param right the ending index of the portion to reverse
     */
    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            // Swap elements at the left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the pointers closer
            left++;
            right--;
        }
    }
}
