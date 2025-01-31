package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
//https://algo.monster/liteproblems/55
public class JumpGame {

    /**
     * Determines if it is possible to reach the last index of the array starting from the first index.
     * <p>
     * The method uses a greedy algorithm to calculate the farthest index reachable at each step.
     * If at any point the current index is beyond the farthest reachable index, the method returns false.
     *
     * @param nums An array of non-negative integers, where each element represents the maximum jump length from that position.
     * @return true if the last index can be reached; false otherwise.
     * <p>
     * Edge Cases:
     * - Single element array: Always true (already at the last index).
     * - Array with zeros blocking the path: Returns false if a zero blocks all forward movement.
     * <p>
     * Time Complexity: O(n) - Iterates through the array once.
     * Space Complexity: O(1) - Uses a constant amount of extra space.
     */
    public boolean canJump(int[] nums) {
        // Tracks the farthest index reachable at any point during the iteration
        var farthestReachableIndex = 0;

        // Iterate through the array
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // If the current index is beyond the farthest reachable index, return false
            if (currentIndex > farthestReachableIndex) {
                return false;
            }

            // Update the farthest reachable index based on the current index and jump length
            farthestReachableIndex = Math.max(farthestReachableIndex, currentIndex + nums[currentIndex]);
        }

        // After the loop, check if the farthest reachable index covers the last index
        return farthestReachableIndex >= nums.length - 1;
    }
}
