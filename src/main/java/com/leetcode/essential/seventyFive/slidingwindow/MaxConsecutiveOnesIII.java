package com.leetcode.essential.seventyFive.slidingwindow;

//https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
//1004
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0; // Tracks the number of zeros in the current window
        int maxOnes = 0;   // Tracks the maximum length of a valid window with at most k zeros

        // Sliding window with two pointers: i (left) and j (right)
        for (int i = 0, j = 0; j < nums.length; j++) {
            // If the current element is 0, increment the zeroCount
            if (nums[j] == 0) {
                zeroCount++;
            }

            // If the number of zeros in the current window exceeds k, shrink the window
            while (zeroCount > k) {
                // If the element being removed from the window is 0, decrement the zeroCount
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++; // Move the left pointer to reduce the window size
            }

            // Calculate the current window size and update maxOnes if the current window is larger
            maxOnes = Math.max(maxOnes, j - i + 1);
        }

        // Return the maximum length of the subarray that satisfies the condition
        return maxOnes;
    }


}
