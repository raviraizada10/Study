package com.gfg.gfg160.prefixSUm;

public class EqulibriumPoint {
    public static int findEquilibrium(int arr[]) {
        var n = arr.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = arr[0];
        rightSum[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) leftSum[i] = leftSum[i - 1] + arr[i];
        for (int i = n - 2; i > 1; i--) rightSum[i] = rightSum[i + 1] + arr[i];
        for (int i = 0; i < n; i++) if (leftSum[i] == rightSum[i]) return i;
        return -1;
    }
}
