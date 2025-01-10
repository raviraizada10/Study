package com.leetcode.essential.seventyFive.dp.oneDimentional;

//https://leetcode.com/problems/domino-and-tromino-tiling/
//https://algo.monster/liteproblems/790
public class TileTheBoardDominosTrominos {
    /**
     * This method calculates the number of ways to tile a 2xN board using dominoes (1x2) and trominoes (2x1).
     * It uses dynamic programming to efficiently compute the number of tiling possibilities.
     *
     * @param n the length of the board (2 x n).
     * @return the number of ways to tile the board, modulo 1e9 + 7.
     */
    public int numTilings(int n) {
        // Initialize a DP array to store tiling counts for 4 states:
        // dp[0]: fully covered (both rows covered)
        // dp[1]: top row missing (only bottom row is covered)
        // dp[2]: bottom row missing (only top row is covered)
        // dp[3]: transitional state (both rows are missing)
        long[] dp = {1, 0, 0, 0};  // Initial state: only dp[0] is valid for n = 1 (fully covered)

        // Modulo value to prevent overflow. The result will be taken modulo 1e9 + 7.
        int mod = (int) 1e9 + 7;

        // Iterate over the sequence from 1 to n
        for (int i = 1; i <= n; ++i) {
            // Temporary array to hold the new states counts for the current step
            long[] newDp = new long[4];

            // dp[0]: Full covering can be achieved from any previous state
            // A full covering can be achieved by transitioning from any of the previous states.
            newDp[0] = (dp[0] + dp[1] + dp[2] + dp[3]) % mod;

            // dp[1]: Top row missing
            // The top row can be missing by transitioning from the state where the bottom row was missing (dp[2])
            // or from the transitional state (dp[3]).
            newDp[1] = (dp[2] + dp[3]) % mod;

            // dp[2]: Bottom row missing
            // The bottom row can be missing by transitioning from the state where the top row was missing (dp[1])
            // or from the transitional state (dp[3]).
            newDp[2] = (dp[1] + dp[3]) % mod;

            // dp[3]: Transitional state (both rows missing)
            // The transitional state comes solely from the previous full covering state (dp[0]).
            newDp[3] = dp[0];

            // Update the dp array for the next iteration
            dp = newDp;
        }

        // After completing all iterations, the count of fully covered tilings is in dp[0]
        // Return the final result, which is the number of ways to tile a 2 x n board, modulo 1e9 + 7
        return (int) dp[0];
    }
}
