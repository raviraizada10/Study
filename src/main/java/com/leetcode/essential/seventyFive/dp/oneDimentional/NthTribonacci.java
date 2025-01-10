package com.leetcode.essential.seventyFive.dp.oneDimentional;

import java.util.Arrays;

//https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
//https://algo.monster/liteproblems/1137
public class NthTribonacci {
    /**
     * Calculates the nth Tribonacci number iteratively.
     * <p>
     * The Tribonacci sequence is defined as:
     * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
     *
     * @param n The index of the Tribonacci number to calculate.
     * @return The nth Tribonacci number.
     */
    public int tribonacci(int n) {
        // Base cases: T0 = 0, T1 = 1, T2 = 1
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Initialize the first three Tribonacci numbers
        int t0 = 0, t1 = 1, t2 = 1;

        // Iteratively compute the next Tribonacci numbers up to Tn
        for (int i = 3; i <= n; i++) {
            int next = t0 + t1 + t2; // Next Tribonacci number
            t0 = t1; // Move t1 to t0
            t1 = t2; // Move t2 to t1
            t2 = next; // Set next as t2
        }

        // Return the nth Tribonacci number
        return t2;
    }

    /**
     * Calculates the nth Tribonacci number recursively.
     * <p>
     * This approach uses simple recursion to compute the Tribonacci sequence.
     *
     * @param n The index of the Tribonacci number to calculate.
     * @return The nth Tribonacci number.
     */
    public int tribonacciRecursive(int n) {
        // Base cases: T0 = 0, T1 = 1, T2 = 1
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Recursive call to compute the Tribonacci number
        return tribonacciRecursive(n - 1) + tribonacciRecursive(n - 2) + tribonacciRecursive(n - 3);
    }

    /**
     * Calculates the nth Tribonacci number using memoization.
     * <p>
     * This approach optimizes the recursive solution by storing previously computed values.
     *
     * @param n The index of the Tribonacci number to calculate.
     * @return The nth Tribonacci number.
     */
    public int tribonacciMemo(int n) {
        // Create a memoization array to store the results of previously computed Tribonacci numbers
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize all elements as -1 (not computed)

        // Start the recursive computation with memoization
        return tribonacciHelper(n, memo);
    }

    /**
     * Helper function for the memoized Tribonacci calculation.
     *
     * @param n    The index of the Tribonacci number to calculate.
     * @param memo The memoization array storing previously computed results.
     * @return The nth Tribonacci number.
     */
    private int tribonacciHelper(int n, int[] memo) {
        // Base cases: T0 = 0, T1 = 1, T2 = 1
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // If the value has already been computed, return it from the memo array
        if (memo[n] != -1) return memo[n];

        // Compute the value and store it in the memo array
        memo[n] = tribonacciHelper(n - 1, memo) + tribonacciHelper(n - 2, memo) + tribonacciHelper(n - 3, memo);

        // Return the computed value
        return memo[n];
    }

    /**
     * Calculates the nth Tribonacci number using dynamic programming (bottom-up approach).
     * <p>
     * This approach builds the Tribonacci sequence iteratively from the base cases up to the nth value.
     *
     * @param n The index of the Tribonacci number to calculate.
     * @return The nth Tribonacci number.
     */
    public int tribonacciIterative(int n) {
        // Base cases: T0 = 0, T1 = 1, T2 = 1
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Create an array to store the Tribonacci sequence up to Tn
        int[] dp = new int[n + 1];
        dp[0] = 0; // T0 = 0
        dp[1] = dp[2] = 1; // T1 = T2 = 1

        // Build the Tribonacci sequence iteratively
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; // Compute the next Tribonacci number
        }

        // Return the nth Tribonacci number
        return dp[n];
    }

    // Example usage:
    public static void main(String[] args) {
        NthTribonacci tribonacci = new NthTribonacci();

        System.out.println(tribonacci.tribonacci(4));  // Output: 4
        System.out.println(tribonacci.tribonacci(25)); // Output: 1389537

        System.out.println(tribonacci.tribonacciRecursive(4));  // Output: 4
        System.out.println(tribonacci.tribonacciMemo(25)); // Output: 1389537
        System.out.println(tribonacci.tribonacciIterative(25)); // Output: 1389537
    }
}
