package com.codingninjas.babbar.ds.array.med;

public class TrappingRainWater {
    public static long getTrappedWater(long[] arr, int n) {
        // {3, 0, 2, 1, 5, 2, 1 }
        // {3, 3, 3, 3, 5, 5, 5 }
        // { 5, 5, 5, 5, 5, 2, 1}

        long[] left = new long[n];

        long[] right = new long[n];

        int water = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }
}
