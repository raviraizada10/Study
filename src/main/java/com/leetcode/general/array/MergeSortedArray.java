package com.leetcode.general.array;

public class MergeSortedArray {
    /**
     * Merges two sorted arrays nums1 and nums2 into one sorted array.
     * The result is stored in nums1, which has enough space to hold the elements of both arrays.
     *
     * @param nums1 the first sorted array, with additional space at the end for nums2
     * @param m     the number of valid elements in nums1
     * @param nums2 the second sorted array
     * @param n     the number of valid elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the last elements of nums1 and nums2, and the merged array
        int indexNums1 = m - 1; // Last valid element in nums1
        int indexNums2 = n - 1; // Last element in nums2
        int mergedIndex = m + n - 1; // Last position in nums1 to store merged elements

        // Process elements from the back to avoid overwriting nums1
        while (indexNums2 >= 0) { // Continue until all elements of nums2 are merged
            if (indexNums1 < 0 || nums1[indexNums1] <= nums2[indexNums2]) {
                // If nums1 is exhausted or nums2's element is larger, take nums2's element
                nums1[mergedIndex] = nums2[indexNums2];
                indexNums2--; // Move pointer in nums2
            }
            else {
                // Otherwise, take nums1's element
                nums1[mergedIndex] = nums1[indexNums1];
                indexNums1--; // Move pointer in nums1
            }
            mergedIndex--; // Move pointer in the merged array
        }
    }
}
