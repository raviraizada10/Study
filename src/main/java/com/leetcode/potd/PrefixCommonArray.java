package com.leetcode.potd;

import java.util.HashSet;

//https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14
public class PrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> Aset = new HashSet<>();
        HashSet<Integer> Bset = new HashSet<>();
        var n = A.length;
        int[] result = new int[n];
        var common = 0;
        for (int i = 0; i < n; i++) {
            Aset.add(A[i]);
            Bset.add(B[i]);
            if (A[i] == B[i]) common++;
            else {
                if (Aset.contains(B[i])) common++;
                if (Bset.contains(A[i])) common++;
            }
            result[i] = common;
        }
        return result;
    }
}
