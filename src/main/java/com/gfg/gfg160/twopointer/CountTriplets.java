package com.gfg.gfg160.twopointer;

import java.util.Arrays;

public class CountTriplets {
    static int countTriplets(int[] arr, int target) {
        int n = arr.length; // Length of the array
        int tripletCount = 0; // Initialize the count of triplets

        // Sort the array to apply the two-pointer technique
        Arrays.sort(arr);

        // Outer loop: Fix the first element of the triplet
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1; // Pointer to the second element
            int end = n - 1;   // Pointer to the third element

            // Two-pointer technique to find triplets with the current fixed element
            while (start < end) {
                int currentSum = arr[i] + arr[start] + arr[end];

                if (currentSum < target) {
                    // Move the start pointer to the right to increase the sum
                    start++;
                }
                else if (currentSum > target) {
                    // Move the end pointer to the left to decrease the sum
                    end--;
                }
                else {
                    // Count elements equal to arr[start] and arr[end]
                    int leftVal = arr[start], rightVal = arr[end];
                    int leftCount = 0, rightCount = 0;

                    // Count frequency of the value at the start pointer
                    while (start <= end && arr[start] == leftVal) {
                        start++;
                        leftCount++;
                    }

                    // Count frequency of the value at the end pointer
                    while (start <= end && arr[end] == rightVal) {
                        end--;
                        rightCount++;
                    }

                    if (leftVal == rightVal) {
                        // All combinations of identical elements are valid
                        tripletCount += (leftCount * (leftCount - 1)) / 2;
                    }
                    else {
                        // Multiply the counts of left and right values
                        tripletCount += (leftCount * rightCount);
                    }
                }
            }
        }
        return tripletCount; // Return the total count of triplets
    }
}
