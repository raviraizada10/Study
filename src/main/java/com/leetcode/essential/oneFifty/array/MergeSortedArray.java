package com.leetcode.essential.oneFifty.array;

public class MergeSortedArray {
    /**
     * Merges two sorted arrays, nums1 and nums2, into a single sorted array.
     * The merged result will be stored in nums1, which has enough space to hold the elements of both arrays.
     *
     * @param nums1 the first sorted array with extra space to accommodate nums2
     * @param m     the number of valid elements in nums1 (the first m elements)
     * @param nums2 the second sorted array
     * @param n     the number of valid elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for nums1, nums2, and the merged array.
        int indexNums1 = m - 1; // Pointer for the last element in the original part of nums1
        int indexNums2 = n - 1; // Pointer for the last element in nums2
        int mergedIndex = m + n - 1; // Pointer for the last element of the merged array (end of nums1)

        // Iterate over nums2 and nums1 from the end of both arrays.
        while (indexNums2 >= 0) {
            // If nums1 is exhausted, or the current element in nums2 is larger than the current element in nums1
            if (indexNums1 < 0 || nums1[indexNums1] <= nums2[indexNums2]) {
                // Place the current element from nums2 in the merged array
                nums1[mergedIndex] = nums2[indexNums2];
                indexNums2--; // Move to the next element in nums2
            }
            else {
                // The current element in nums1 is larger; place it in the merged array
                nums1[mergedIndex] = nums1[indexNums1];
                indexNums1--; // Move to the next element in nums1
            }
            mergedIndex--; // Move to the next position in the merged array
        }

        // No need to check the remaining elements of nums1, since they are already in their sorted position.
    }
}
