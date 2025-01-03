package com.leetcode.essential.seventyFive.binarysearch;

//https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
//162
//https://algo.monster/liteproblems/162
public class FindPeakElement {
    /**
     * Finds a peak element in the array. A peak element is an element that is greater than its neighbors.
     *
     * @param nums An integer array where nums[i] ≠ nums[i + 1] for all valid i.
     * @return The index of any one peak element.
     */
    public int findPeakElement(int[] nums) {
        // Initialize pointers for binary search.
        int left = 0; // Start of the array.
        int right = nums.length - 1; // End of the array.

        // Perform binary search to find the peak.
        while (left < right) {
            // Calculate the mid-point to split the array.
            int mid = left + (right - left) / 2;

            // Check if the mid element is greater than its next neighbor.
            if (nums[mid] > nums[mid + 1]) {
                // If nums[mid] > nums[mid + 1], the peak lies in the left half (including mid).
                right = mid;
            } else {
                // If nums[mid] <= nums[mid + 1], the peak lies in the right half (excluding mid).
                left = mid + 1;
            }
        }

        // After the loop, left == right, pointing to the peak element.
        return left;
    }
}
