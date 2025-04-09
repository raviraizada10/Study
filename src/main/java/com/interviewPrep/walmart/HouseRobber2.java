package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/house-robber-ii/", problemNumber = "213", solutionLink = "https://algo.monster/liteproblems/213")
public class HouseRobber2 {

    /**
     * Solves the House Robber II problem where houses are arranged in a circle.
     * You cannot rob both the first and last houses. So, we compute two cases:
     * - Rob from house 0 to n-2 (exclude last house)
     * - Rob from house 1 to n-1 (exclude first house)
     * The answer is the max of both cases.
     *
     * @param nums the array representing money in each house
     * @return the maximum amount that can be robbed without alerting the police
     *
     * Edge Cases:
     * - No houses => return 0
     * - One house => return its value
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Exclude last house
        int excludeLastHouse = robLinear(nums, 0, n - 2);

        // Exclude first house
        int excludeFirstHouse = robLinear(nums, 1, n - 1);

        return Math.max(excludeLastHouse, excludeFirstHouse);
    }

    /**
     * Helper method to solve House Robber problem for a linear set of houses.
     * Uses constant space DP with two variables tracking max robbed till two previous houses.
     *
     * @param nums  the input array of house values
     * @param start start index (inclusive)
     * @param end   end index (inclusive)
     * @return the max amount rob-able from this linear subarray
     */
    private int robLinear(int[] nums, int start, int end) {
        int twoHousesAgoMax = 0, oneHouseAgoMax = 0;

        for (int i = start; i <= end; i++) {
            // Either rob current and add to total from two houses ago,
            // or skip and take total till previous house
            int currentMax = Math.max(oneHouseAgoMax, nums[i] + twoHousesAgoMax);
            twoHousesAgoMax = oneHouseAgoMax;
            oneHouseAgoMax = currentMax;
        }

        return oneHouseAgoMax;
    }
}