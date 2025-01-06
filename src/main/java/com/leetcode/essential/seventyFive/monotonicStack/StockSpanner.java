package com.leetcode.essential.seventyFive.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/online-stock-span/?envType=study-plan-v2&envId=leetcode-75
//901
//https://algo.monster/liteproblems/901
public class StockSpanner {
    // Stack to keep track of stock prices and span counts
    // Each stack element is an array with the first element being the stock price
    // and the second being the span count for that price
    private Deque<int[]> stack = new ArrayDeque<>();

    // Constructor for StockSpanner
    public StockSpanner() {
    }

    // This method is called for every new stock price and returns the span count
    // The span count is the number of consecutive days the stock price has been
    // less than or equal to the current day's price, including the current day
    public int next(int price) {
        // Start the count as 1 for the current day
        int count = 1;

        // Continue popping elements from the stack when the current price is greater
        // than the price at the stack's top and accumulate the span counts
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }

        // Push the current price along with its span count onto the stack
        stack.push(new int[]{price, count});

        // Return the computed span count for the current price
        return count;
    }
}
