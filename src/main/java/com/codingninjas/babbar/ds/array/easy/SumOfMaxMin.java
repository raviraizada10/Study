package com.codingninjas.babbar.ds.array.easy;

public class SumOfMaxMin {
    public static int sumOfMaxMin(int[] arr, int n) {
        int min = arr[0];
        int max = arr[0];
        for (int j : arr) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        return min + max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6, 6, 6};
        sumOfMaxMin(arr, 7);
    }
}
