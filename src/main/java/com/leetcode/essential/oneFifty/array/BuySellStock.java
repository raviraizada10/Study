package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
//https://algo.monster/liteproblems/121

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.DYNAMIC_PROGRAMMING;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY, DYNAMIC_PROGRAMMING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/", problemNumber = "121", solutionLink = "https://algo.monster/liteproblems/121")
public class BuySellStock {
    /**
     * This method calculates the maximum profit that can be made from buying and selling a stock
     * given an array of prices where each element represents the price of the stock on a particular day.
     * <p>
     * The algorithm works by iterating through the prices while keeping track of the minimum price encountered
     * so far and the maximum profit that can be achieved by selling at the current price.
     * <p>
     * The time complexity of this solution is O(n), where n is the number of days (length of the prices array),
     * and the space complexity is O(1), as we are only using a few extra variables to store intermediate results.
     *
     * @param prices an array of integers representing the stock prices on different days.
     * @return the maximum profit that can be achieved, or 0 if no profit can be made.
     */
    public int maxProfit(int[] prices) {
        // Variable to store the maximum profit
        int maximumProfit = 0;

        // Variable to store the minimum price encountered so far
        int minimumPriceSoFar = prices[0];

        // Iterate through the array of prices to find the maximum profit
        for (int currentPrice : prices) {
            // Calculate the profit if we sold the stock at the current price
            maximumProfit = Math.max(maximumProfit, currentPrice - minimumPriceSoFar);

            // Update the minimum price encountered so far
            minimumPriceSoFar = Math.min(minimumPriceSoFar, currentPrice);
        }

        // Return the maximum profit
        return maximumProfit;
    }
}
