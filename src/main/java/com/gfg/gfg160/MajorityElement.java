package com.gfg.gfg160;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    /**
     * Finds all majority elements in the array that appear more than n/3 times.
     *
     * @param nums The input array of integers.
     * @return A list of integers that are majority elements, sorted in ascending order.
     */
    public static List<Integer> findMajority(int[] nums) {
        int n = nums.length;

        // Variables to store potential candidates for majority elements
        int candidate1 = 0, candidate2 = 0;

        // Counts of the potential candidates
        int count1 = 0, count2 = 0;

        // First pass: Identify potential candidates
        for (int number : nums) {
            if (number == candidate1) {
                // Increment count for candidate1 if the number matches
                count1++;
            }
            else if (number == candidate2) {
                // Increment count for candidate2 if the number matches
                count2++;
            }
            else if (count1 == 0) {
                // Assign a new candidate1 if its count is zero
                candidate1 = number;
                count1 = 1;
            }
            else if (count2 == 0) {
                // Assign a new candidate2 if its count is zero
                candidate2 = number;
                count2 = 1;
            }
            else {
                // Reduce counts for both candidates when the number matches neither
                count1--;
                count2--;
            }
        }

        // Second pass: Verify the counts of the candidates
        count1 = 0;
        count2 = 0;
        for (int number : nums) {
            if (number == candidate1) {
                count1++;
            }
            else if (number == candidate2) {
                count2++;
            }
        }

        // Collect the valid majority elements
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        // Sort the result to return elements in ascending order
        result.sort(Integer::compareTo);
        return result;
    }

    public static void main(String[] args) {
        // Test the findMajority method with a sample input
        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println(findMajority(arr));  // Output: [5, 6]
    }
}
