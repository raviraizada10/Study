package com.gfg.gfg160;

public class KadnesAlgorithm {
    int maxSubarraySum(int[] arr) {
        var currentSum = 0;
        var maxSum = 0;
        for (int j : arr) {
            if (currentSum < 0) currentSum = j;
            else currentSum += j;
            if (maxSum < currentSum) maxSum = currentSum;
        }
        return maxSum;
    }
}
