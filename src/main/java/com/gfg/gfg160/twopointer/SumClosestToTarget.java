package com.gfg.gfg160.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumClosestToTarget {
    public List<Integer> sumClosest(int[] arr, int target) {
        // Sort the array to apply the two-pointer technique
        Arrays.sort(arr);

        // Initialize the minimum difference to the largest possible integer value
        var minDiff = Integer.MAX_VALUE;

        // Initialize the result list to store the closest pair of numbers
        List<Integer> result = new ArrayList<Integer>();

        // Use two pointers: one starting from the beginning (left) and one from the end (right)
        for (int left = 0, right = arr.length - 1; left < right; ) {

            // Calculate the sum of the current pair of elements
            var currSum = arr[left] + arr[right];

            // Calculate the absolute difference between the current sum and the target
            var currDiff = Math.abs(currSum - target);

            // If the current difference is smaller than the minimum difference found so far
            if (currDiff < minDiff) {
                // Update the minimum difference to the current difference
                minDiff = currDiff;

                // Update the result list with the current pair of numbers
                result = List.of(arr[left], arr[right]);
            }
            // If the current sum is less than the target, move the left pointer to the right
            else if (currSum < target) {
                left++;
            }
            // If the current sum is greater than the target, move the right pointer to the left
            else {
                right--;
            }
        }

        // Return the result list, which contains the pair whose sum is closest to the target
        return result;
    }
}
