package com.leetcode.potd;

//https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03
//2270
//https://algo.monster/liteproblems/2270
public class WaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        long totalSum =0;
        for (int num : nums) {
            totalSum+=num;
        }
        long runningSum = 0L;
        int count = 0;
        for (int i = 0; i < nums.length -1; i++) {
            runningSum += nums[i];
            if(runningSum >= totalSum - runningSum) count++;
        }
        return count;
    }
}
