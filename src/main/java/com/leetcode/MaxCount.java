package com.leetcode;

import java.util.HashSet;

//https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
public class MaxCount {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        int maxIntegers = 0;
        int currSum = 0;
        for (int num : banned) {
            bannedSet.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if(currSum < maxSum && !bannedSet.contains(i)){
                currSum+=i;
                maxIntegers++;
            }
        }
        return maxIntegers;
    }
}
