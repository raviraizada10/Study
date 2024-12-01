package com.leetcode;

public class EncryptedSum {
    public int sumOfEncryptedInt(int[] nums) {
        int maxSum = 0;
        for (int num : nums) {
            maxSum += findMax(num);
        }
        return maxSum;
    }

    private int findMax(int num) {
        int max = 0;
        var tmp = 0;
        int len = 0;
        while (num > 0) {
            tmp = num % 10;
            max = Math.max(max, tmp);
            num /= 10;
            len++;
        }
        tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = tmp * 10 + max;
        }
        return tmp;
    }
}
