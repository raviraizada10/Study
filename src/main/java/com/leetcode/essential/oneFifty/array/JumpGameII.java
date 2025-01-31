package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
//https://algo.monster/liteproblems/55
public class JumpGameII {


    public int jump(int[] nums) {
        // Tracks the farthest index we can reach with our current set of jumps
        int farthestReachableIndex = 0;
        // Tracks the boundary of our current jump range
        int currentJumpEnd = 0;
        // Counts the minimum jumps needed
        int jumps = 0;

        // Iterate through the array
        for (int currentIndex = 0; currentIndex < nums.length - 1; currentIndex++) {
            // Update the farthest reachable index based on the current index and jump length
            farthestReachableIndex = Math.max(farthestReachableIndex, currentIndex + nums[currentIndex]);
            // When we reach the end of our current jump range
            if (currentIndex == currentJumpEnd) {
                // We must take another jump to continue
                jumps++;
                // Our next jump can take us up to the farthest position we've seen
                currentJumpEnd = farthestReachableIndex;

                // If we can already reach the end, no need to continue
                if (currentJumpEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        // After the loop, check if the farthest reachable index covers the last index
        return jumps;
    }
}