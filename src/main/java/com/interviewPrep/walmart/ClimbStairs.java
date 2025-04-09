package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(
    problemLink = "https://leetcode.com/problems/climbing-stairs/",
    problemNumber = "70",
    solutionLink = "https://algo.monster/liteproblems/70"
)
/**
 * Class to solve the Climbing Stairs problem.
 * Given n steps, you can climb either 1 or 2 steps at a time.
 * This class provides both memoization and tabulation-based solutions
 * to find the total number of distinct ways to reach the top.
 */
public class ClimbStairs {

    /**
     * Calculates number of ways to climb 'n' stairs using memoization.
     * @param n the number of stairs
     * @return number of unique ways to climb to the top
     *
     * Edge Cases:
     * - If n = 0 or 1, there's only one way to climb.
     */
    public int climbStairs(int n) {
        int[] memoizationArray = new int[n + 1];
        Arrays.fill(memoizationArray, -1);
        return climbStairs(n, memoizationArray);
    }

    /**
     * Recursive helper with memoization.
     * @param n current stair index
     * @param memoizationArray stores previously computed results
     * @return number of ways to climb to step n
     */
    public int climbStairs(int n, int[] memoizationArray) {
        // Base case: 0 or 1 step has only 1 way to reach
        if (n <= 1) return 1;

        // Return cached result if already computed
        if (memoizationArray[n] != -1) return memoizationArray[n];

        // Store the result for reuse: sum of ways from previous two steps
        memoizationArray[n] = climbStairs(n - 1, memoizationArray) + climbStairs(n - 2, memoizationArray);
        return memoizationArray[n];
    }

    /**
     * Calculates number of ways to climb 'n' stairs using tabulation (bottom-up DP).
     * @param n the number of stairs
     * @return number of unique ways to climb to the top
     */
    public int climbStairsTabulation(int n) {
        // Base case: 0 or 1 step
        if (n <= 1) return 1;

        int[] waysToClimb = new int[n + 1];
        waysToClimb[0] = 1;
        waysToClimb[1] = 1;

        // Build the dp array from bottom up
        for (int i = 2; i <= n; i++) {
            waysToClimb[i] = waysToClimb[i - 1] + waysToClimb[i - 2];
        }

        return waysToClimb[n];
    }
}