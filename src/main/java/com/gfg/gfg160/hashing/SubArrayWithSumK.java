package com.gfg.gfg160.hashing;

import java.util.HashMap;

public class SubArrayWithSumK {
    public int countSubarrays(int arr[], int k) {
        int prefixSum = 0, count = 0;
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap();
        prefixSumFrequency.put(0, 1);
        for (int element : arr) {
            prefixSum += element;
            count += prefixSumFrequency.getOrDefault(prefixSum - k, 0);
            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
