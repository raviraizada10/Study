package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//https://algo.monster/liteproblems/26
public class RemoveDuplicates {
    /**
     * Removes duplicates from a sorted array in-place, such that each unique element appears only once.
     * The relative order of elements is maintained.
     *
     * @param nums the input array of integers, sorted in non-decreasing order
     * @return the number of unique elements in the array
     *
     * The first `return value` elements of the input array `nums` will contain the unique elements.
     */
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0 as there are no unique elements
        if (nums.length == 0) return 0;

        // Pointer to track the position of the last unique element
        int left = 0;

        // Iterate through the array starting from the second element
        for (int right = 1; right < nums.length; right++) {
            // If the current element is different from the last unique element
            if (nums[left] != nums[right]) {
                left++; // Move the left pointer to the next position
                nums[left] = nums[right]; // Place the unique element at the left pointer
            }
        }

        // Return the count of unique elements, which is left + 1
        return left + 1;
    }
}
