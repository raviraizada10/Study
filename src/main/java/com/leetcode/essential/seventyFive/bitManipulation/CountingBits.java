package com.leetcode.essential.seventyFive.bitManipulation;

//https://leetcode.com/problems/counting-bits/
//338
//https://algo.monster/liteproblems/338
public class CountingBits {
    public int[] countBits(int n) {
        // Step 1: Initialize an array of size n + 1 to store the number of 1's for each number.
        int[] ans = new int[n + 1];

        // Step 2: Loop through all integers from 1 to n (inclusive).
        for (int i = 1; i <= n; i++) {
            // Step 3: Apply the i & (i - 1) trick to compute the number of 1's in i.
            // This trick removes the least significant 1-bit in i, and we add 1 because i has at least one 1-bit.
            ans[i] = ans[i & (i - 1)] + 1;
        }

        // Step 4: Return the array ans, which contains the number of 1's for each number from 0 to n.
        return ans;
    }
}
