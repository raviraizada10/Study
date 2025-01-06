package com.gfg.gfg160.twopointer;

import java.util.Arrays;

public class CountPairs {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        var left = 0;
        var right = arr.length - 1;
        var count = 0;
        while (left < right) {
            var sum = arr[left] + arr[right];
            if (sum < target) {
                count += right - left;
                right--;
            }
            else {
                left--;
            }
        }
        return count;
    }
}
