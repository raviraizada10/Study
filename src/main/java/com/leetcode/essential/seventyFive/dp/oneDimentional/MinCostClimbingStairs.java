package com.leetcode.essential.seventyFive.dp.oneDimentional;

//https://leetcode.com/problems/min-cost-climbing-stairs/
//https://algo.monster/liteproblems/746
public class MinCostClimbingStairs {
    /**
     * Calculates the minimum cost to reach the top of a staircase, where you can start at step 0 or step 1,
     * and each step has an associated cost.
     * <p>
     * The goal is to minimize the cost of reaching the top by either stepping from the previous step or skipping one step.
     *
     * @param cost An array where cost[i] represents the cost of stepping on the ith stair.
     * @return The minimum cost to reach the top of the staircase.
     */
    public int minCostClimbingStairs(int[] cost) {
        // If there is only one step, the minimum cost is the cost of that step.
        if (cost.length == 1) return cost[0];

        // If there are only two steps, the minimum cost is the smaller of the two.
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        // Initialize the costs for the two base cases:
        // previousToPrevious represents the cost to reach step 0.
        // previous represents the cost to reach step 1.
        var previousToPrevious = cost[0];
        var previous = cost[1];

        // Iterate through the array starting from the 2nd index, as steps 0 and 1 are base cases.
        for (int i = 2; i < cost.length; i++) {
            // Calculate the cost to reach the current step.
            // You can come from either the previous step or the one before it.
            var current = cost[i] + Math.min(previous, previousToPrevious);

            // Update the values for the next iteration:
            // Shift the previous to the step before it.
            previousToPrevious = previous;

            // Shift the current step to be the previous step.
            previous = current;
        }

        // The final answer is the minimum cost to reach either of the last two steps.
        // You can finish at the second-to-last step or the last step, so take the minimum of both.
        return Math.min(previous, previousToPrevious);
    }
}
