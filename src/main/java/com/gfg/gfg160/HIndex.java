package com.gfg.gfg160;

import java.util.Arrays;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/find-h-index--165609
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // Papers with citations >= citations[i]
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
}
