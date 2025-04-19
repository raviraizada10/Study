package com.leetcode.essential.seventyFive.dp.twoDimentional;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, DYNAMIC_PROGRAMMING, GREEDY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/", problemNumber = "714", solutionLink = "https://algo.monster/liteproblems/714")
public class BuySellWithFee {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}   