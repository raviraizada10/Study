package com.leetcode.potd;

//https://leetcode.com/problems/max-chunks-to-make-sorted/description/
//769
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        // Tracks the maximum value encountered so far
        int maxSoFar = 0;

        // Counter for the number of chunks
        int chunks = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update maxSoFar with the maximum value seen so far
            maxSoFar = Math.max(maxSoFar, arr[i]);

            // If maxSoFar equals the current index, we can form a chunk
            if (maxSoFar == i) {
                chunks++;
            }
        }

        // Return the total number of chunks
        return chunks;
    }

}
