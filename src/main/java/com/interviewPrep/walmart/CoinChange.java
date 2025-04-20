package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/coin-change/description/", problemNumber = "322", solutionLink = "https://algo.monster/liteproblems/322")
public class CoinChange {
    /**
     * 📝 Coin Change – Bottom-Up Dynamic Programming
     * Use a DP array where dp[i] stores the minimum number of coins needed to make amount i.
     * Initialize all values with a high number (amount + 1) to simulate infinity, except dp[0] = 0.
     * For each coin, update dp[i] from coin to amount as:
     * dp[i] = min(dp[i], dp[i - coin] + 1)
     * Final answer is dp[amount], or -1 if it’s still unachievable.
     *
     * @param coins  array of coin denominations
     * @param amount total amount to make up
     * @return minimum number of coins needed to make the amount; -1 if not possible
     * <p>
     * Edge Cases:
     * - If amount is 0, returns 0.
     * - If coins array is empty or no combination can form the amount, returns -1.
     */
    public int coinChange(int[] coins, int amount) {
        // Array to store the minimum coins needed for every amount from 0 to 'amount'
        int[] minCoinsRequired = new int[amount + 1];

        // Initialize with a value greater than the maximum possible (amount + 1 acts like infinity)
        Arrays.fill(minCoinsRequired, amount + 1);
        minCoinsRequired[0] = 0; // Base case: 0 coins needed for amount 0

        // For each coin, update the DP table
        for (int coin : coins) {
            for (int currentAmount = coin; currentAmount <= amount; currentAmount++) {
                // Update if taking this coin leads to fewer coins
                minCoinsRequired[currentAmount] = Math.min(minCoinsRequired[currentAmount],
                        1 + minCoinsRequired[currentAmount - coin]);
            }
        }

        // If the amount index has not been updated, return -1 (impossible to form)
        return minCoinsRequired[amount] > amount ? -1 : minCoinsRequired[amount];
    }
}