package com.gfg.gfg160;

public class BuySellMaximum {
    public int maximumProfit(int prices[]) {
        int totalProfit = 0;
        for (int i = 0, j = 1; i < prices.length -1; i++, j++) {
            if(prices[i] < prices[j]){
                totalProfit += prices[j] - prices[i];
            }
        }
        return totalProfit;
    }
}
