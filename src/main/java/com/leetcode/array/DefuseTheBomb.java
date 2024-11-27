package com.leetcode.array;

import java.util.Arrays;

//https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18
public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            Arrays.fill(result, 0);
            return result;
        }

        int start = k > 0 ? 1 : n + k; // Start index for summing
        int end = k > 0 ? k : n - 1;  // End index for summing
        int windowSum = 0;

        // Compute the initial window sum
        for (int i = start; i <= end; i++) {
            windowSum += code[i % n];
        }

        // Slide the window and compute the result
        for (int i = 0; i < n; i++) {
            result[i] = windowSum;
            // Slide the window
            windowSum -= code[start % n];
            start++;
            end++;
            windowSum += code[end % n];
        }
        return result;
    }
}
