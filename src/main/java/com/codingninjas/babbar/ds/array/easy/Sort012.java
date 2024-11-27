package com.codingninjas.babbar.ds.array.easy;

public class Sort012 {
    public static void sort012(int[] arr) {
        for (int low = 0, mid = 0, high = arr.length - 1; mid <= high; ) {
            switch (arr[mid]) {
                case 0: {
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,1,0};
        sort012(arr);
    }
}

