package com.gfg.gfg160;

public class BuySellMaximumSingleTransaction {
    // [7, 10, 1, 3, 6, 9, 2]
    // [0, 3, -9, 2, 3, 3, -7] 
    public int maximumProfit(int prices[]) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPriceSoFar = Integer.MAX_VALUE;
        int maximumProfit = 0;
        for (int price : prices) {
            if (price < minPriceSoFar) {
                minPriceSoFar = price;
            }
            int profit = price - minPriceSoFar;
            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
        }
        return maximumProfit;
    }
}
