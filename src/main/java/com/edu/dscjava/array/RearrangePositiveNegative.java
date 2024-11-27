package com.edu.dscjava.array;

public class RearrangePositiveNegative {
    public static void rearrange(int[] arr) {
        for (int i = 0, j = 1; i < j && j < arr.length; ) {
            if (arr[i] >= 0) {
                if (arr[j] < 0) swap(arr, i, j);
                else j++;
            }
            else {
                i++;
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void rearrangeSol(int[] arr) {
        int leftMostPosEle = 0;
        for (int curr = 0; curr < arr.length; curr++) {
            if (arr[curr] < 0) {
                if (curr != leftMostPosEle) {
                    swap(arr, curr, leftMostPosEle);
                }
                leftMostPosEle++;
            }
        }
    }
}
