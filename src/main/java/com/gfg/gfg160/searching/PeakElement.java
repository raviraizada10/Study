package com.gfg.gfg160.searching;

public class PeakElement {
    public int peakElement(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }
}
