package com.gfg.gfg160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    static List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            int[] currentInterval = arr[i];

            if (currentInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                mergedIntervals.add(new int[]{currentInterval[0], currentInterval[1]});
            }
        }

        return mergedIntervals;
    }
}
