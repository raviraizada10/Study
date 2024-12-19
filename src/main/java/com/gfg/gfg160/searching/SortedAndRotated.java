package com.gfg.gfg160.searching;

public class SortedAndRotated {
    public int findMin(int[] arr) {
        if(arr.length == 1) return arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) return arr[i];
        }
        return -1;
    }
}
