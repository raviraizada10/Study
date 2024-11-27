package com.gfg.gfg160;

public class MaxCircularSubarraySum {
    public int circularSubarraySum(int arr[]) {
        int totalSum = 0, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int currentMax = 0, currentMin = 0;

        for (int num : arr) {
            totalSum += num;
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);

    }
}
