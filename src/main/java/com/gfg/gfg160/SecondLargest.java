package com.gfg.gfg160;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/second-largest3735
public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            max = Math.max(max, j);
        }
        int secondLargest = 0;
        for (int j : arr) {
            if (j != max) {
                secondLargest = Math.max(secondLargest, j);
            }
        }
        return secondLargest;
    }

    public int getSecondLargest_singleIteration(int[] arr) {
        int max = -1, secondMax = -1;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }

        return 0;
    }
}
