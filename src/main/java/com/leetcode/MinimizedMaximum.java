package com.leetcode;

public class MinimizedMaximum {
    public int minimizedMaximum(int n, int[] quantities) {
        double sum = 0;
        for (int quantity : quantities) {
            sum += quantity;
        }
        return (int)(sum / (double) n);
    }
}
