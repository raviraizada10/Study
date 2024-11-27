package com.gfg.gfg160;

public class ReverseArray {
    public void reverseArray(int arr[]) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

