package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/house-robber/", problemNumber = "198", solutionLink = "https://algo.monster/liteproblems/198")
public class HouseRobber {
    /**
     * 📝 House Robber – Dynamic Programming
     * At each house, decide to either rob it (and add the value from i-2) or skip it (take the value from i-1).
     * Use bottom-up DP or memoized recursion to compute the max sum without robbing adjacent houses.
     * Space can be optimized by keeping track of only the last two computed values.
     *
     * @param nums an array representing the amount of money at each house
     * @return the maximum amount of money that can be robbed without robbing adjacent houses
     * <p>
     * Edge Cases:
     * - If there are no houses, return 0.
     * - If there's only one house, return its value.
     */
    public int robTab(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // No houses to rob
        if (n == 1) return nums[0]; // Only one house, rob it

        // DP array where dp[i] represents the max amount rob-able from house 0 to i
        int[] dp = new int[n];
        dp[0] = nums[0]; // Only one house, rob it
        dp[1] = Math.max(nums[0], nums[1]); // Choose the richer of the first two

        // Bottom-up computation for each house starting from index 2
        for (int houseIndex = 2; houseIndex < n; houseIndex++) {
            // Either skip current house or rob it and add value from two houses back
            dp[houseIndex] = Math.max(dp[houseIndex - 1], nums[houseIndex] + dp[houseIndex - 2]);
        }

        return dp[n - 1]; // Maximum rob amount is at the last house
    }

    int robSpaceOptimisedDP(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = Math.max(curr, nums[i] + prev);
            prev = curr;
            curr = temp;
        }

        return curr;
    }

    int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(n - 1, nums, memo);
    }

    int helper(int houseIndex, int[] nums, int[] memo) {
        if (houseIndex < 0) return 0;
        if (memo[houseIndex] != -1) return memo[houseIndex];

        int pick = nums[houseIndex] + helper(houseIndex - 2, nums, memo);
        int skip = helper(houseIndex - 1, nums, memo);

        memo[houseIndex] = Math.max(pick, skip);
        return memo[houseIndex];
    }
}