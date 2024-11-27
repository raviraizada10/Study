package com.gfg.gfg160;

import java.util.HashSet;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/smallest-positive-missing-number-1587115621
public class SmallestPositiveMissingNumber {
    public int missingNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (num > 0) {
                set.add(num);
            }
        }

        int smallestMissing = 1;
        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }
        return smallestMissing;
    }
}
