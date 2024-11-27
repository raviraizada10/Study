package com.codingninjas.babbar.ds.array.easy;

import java.util.Arrays;

/*
 * https://www.codingninjas.com/codestudio/problems/minimize-the-difference_3208652?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0
 * 4 2
 * [1, 5, 8, 10]
 */
public class MinimizeIt {
    public static int minimizeIt(int[] A, int K) {
        int len = A.length;
        Arrays.sort(A);
        int ans = A[len - 1] - A[0];
        int min = A[0] + K;
        int max = A[len - 1] - K;
        return 0;
    }
}
