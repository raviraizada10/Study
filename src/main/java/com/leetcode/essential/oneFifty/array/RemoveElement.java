package com.leetcode.essential.oneFifty.array;


//https://leetcode.com/problems/remove-element/
//https://algo.monster/liteproblems/27
public class RemoveElement {
    /**
     * Removes all occurrences of a specific value `val` from the input array `nums`.
     * <p>
     * This method modifies the input array `nums` in-place, shifting elements to the left
     * whenever a value that is not equal to `val` is encountered. It returns the number of
     * elements remaining in the array after the removal of all occurrences of `val`.
     *
     * @param nums the input array of integers
     * @param val  the value to be removed from the array
     * @return the number of elements in the array after the removal of `val`
     */
    public int removeElement(int[] nums, int val) {
        // `k` keeps track of the position where the next valid element should be placed
        int k = 0;

        // Iterate through the array
        for (int num : nums) {
            // If the current number is not equal to `val`, we keep it
            if (num != val) {
                // Place the current number at the position `k`
                nums[k++] = num;
            }
        }

        // Return the count of elements that are not equal to `val`
        return k;
    }
}
