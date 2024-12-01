package com.leetcode;

import java.util.HashSet;

public class NandDouble {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr) {
            var doubleVal = j * 2;
            var halfVal = j / 2;
            if (set.contains(doubleVal) || (j % 2 == 0 && set.contains(halfVal))) {
                return true;
            }
            set.add(j);
        }
        return false;
    }
}
