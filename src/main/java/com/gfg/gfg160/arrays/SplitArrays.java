package com.gfg.gfg160.arrays;

import java.util.Arrays;
import java.util.List;

public class SplitArrays {
    public List<Integer> findSplit(int[] arr) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum+=i;
        }
        if (totalSum % 3 != 0) {
            return Arrays.asList(-1, -1);
        }
        int desiredPartitionSum  = totalSum /3;
        int currentPartitionSum = 0;
        int firstIndex = -1, secondIndex =-1;
        for (int i = 0; i < arr.length; i++) {
            currentPartitionSum += arr[i];
            if (currentPartitionSum == desiredPartitionSum && firstIndex == -1) {
                firstIndex = i;
            } else if (currentPartitionSum == 2 * desiredPartitionSum && secondIndex == -1) {
                secondIndex = i;
            }
            if (firstIndex != -1 && secondIndex != -1) {
                break;
            }
        }
        return Arrays.asList(firstIndex, secondIndex);
    }
}
