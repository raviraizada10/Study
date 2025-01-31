package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
//https://algo.monster/liteproblems/122
public class BuySellStockMultipleTimes {
    /**
     * Calculates the maximum profit achievable by buying and selling a stock multiple times.
     *
     * @param prices An array of integers representing the prices of a stock on consecutive days.
     * @return The maximum profit that can be achieved.
     */
    public int maxProfit(int[] prices) {
        // Initialize profitSoFar to track the total profit accumulated from all transactions
        int profitSoFar = 0;

        // Initialize prevPrice with the price on the first day
        int prevPrice = prices[0];

        // Iterate through the prices array starting from the second element
        for (int i = 1; i < prices.length; i++) {
            // Get the current price of the stock on the i-th day
            int currentPrice = prices[i];

            // Check if the current price is higher than or equal to the previous price
            if (currentPrice >= prevPrice) {
                // Calculate the profit from buying at prevPrice and selling at currentPrice
                profitSoFar += currentPrice - prevPrice;
            }
            else {
                // Update prevPrice to the current price if currentPrice < prevPrice
                prevPrice = currentPrice;
            }
        }

        // Return the total maximum profit that can be achieved
        return profitSoFar;
    }


}
