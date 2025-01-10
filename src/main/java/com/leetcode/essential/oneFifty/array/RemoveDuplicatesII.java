package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
//https://algo.monster/liteproblems/80
public class RemoveDuplicatesII {
    /**
     * Removes duplicates from the sorted input array `nums`, allowing at most two occurrences of each element.
     * <p>
     * The method modifies the input array `nums` in-place such that each element appears at most twice.
     * It returns the number of elements in the modified array after duplicates have been removed.
     * <p>
     * The array is assumed to be sorted in non-decreasing order.
     *
     * @param nums the input sorted array of integers
     * @return the number of elements in the array after duplicates have been removed,
     * allowing at most two occurrences of each element
     */
    public int removeDuplicates(int[] nums) {
        // `index` is used to keep track of the position where the next unique element should be placed.
        int index = 0;

        // Iterate through the array to find duplicates
        for (int num : nums) {
            // Allow at most two occurrences of each number
            // `index < 2` ensures that the first two occurrences of each number are allowed
            // `num != nums[index - 2]` ensures that the third occurrence of a number is skipped
            if (index < 2 || num != nums[index - 2]) {
                // Place the current number in the `index`th position
                nums[index] = num;
                // Move to the next position
                index++;
            }
        }

        // Return the number of valid elements in the array
        return index;
    }
}
