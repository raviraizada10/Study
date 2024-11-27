package com.leetcode.array;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/?envType=daily-question&envId=2024-11-16
public class PowerOfKSizeSubarray {
    public int[] resultsArray(int[] nums, int k) {
        int[] results = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int j = i + k;
            var subArray = Arrays.copyOfRange(nums, i, j);
            results[i] = maxPowerOfSubArray(subArray);
        }
        return results;
    }

    private int maxPowerOfSubArray(int[] subArray) {
        int max = subArray[0];
        for (int i = 0, j = 1; j < subArray.length; i++, j++) {
            if (subArray[i] + 1 == subArray[j]) {
                max = Math.max(max, subArray[j]);
            }
            else {
                max = -1;
                break;
            }
        }
        return max;
    }
}
