package com.codingninjas.babbar.ds.array.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {

    public static void reverseArray(ArrayList<Integer> arr, int m) {
        for (int i = m + 1, j = arr.size() - 1; i < j; i++, j--) {
            swap(arr, i, j);
            System.out.println(arr);
        }
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        ReverseArray.reverseArray(arr, 3);
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(10, 9, 8, 7, 6));
        ReverseArray.reverseArray(arr2, 3);
    }
}
