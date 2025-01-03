package com.gfg.gfg160.sorting;

import java.util.Arrays;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-bonus-problems/problem/minimum-sum4058
public class MinimumSum {
    String minSum(int[] arr) {
        Arrays.sort(arr);
        StringBuilder first = new StringBuilder("0");
        StringBuilder second = new StringBuilder("0");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                first.append(arr[i]);
            }
            else {
                second.append(arr[i]);
            }
        }
        int result = Integer.parseInt(first.toString()) + Integer.parseInt(second.toString());
        return String.valueOf(result);
    }
}
