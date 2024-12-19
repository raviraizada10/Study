package com.gfg.gfg160.searching;

public class KthMissingPositive {
    public int kthMissing(int[] arr, int k) {
        //missing(i) = arr[i] - (i + 1)
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
