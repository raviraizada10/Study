package com.edu.grok.patterns.twopointer;

public class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        for (int i = 0, j = arr.length -1; i < j; ) {
            if (arr[i] + arr[j] == targetSum) {
                return new int[]{i, j};
            }
            else if (arr[i] + arr[j] > targetSum) {
                j--;
            }
            else if (arr[i] + arr[j] < targetSum) {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
