package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/two-sum/description/", problemNumber = "1", solutionLink = "https://algo.monster/liteproblems/1")
public class TwoSum {

    /**
     * Finds two distinct indices in the array such that the numbers at those indices add up to the target.
     *
     * @param nums   the input array of integers
     * @param target the target sum to find
     * @return an array of two indices whose elements sum up to the target;
     *         returns an empty array if no such pair is found
     *
     * Edge Cases:
     * - If the array is empty or has fewer than 2 elements, returns empty array.
     * - Assumes there is exactly one valid solution as per problem constraints.
     */
    public int[] twoSum(int[] nums, int target) {
        // Map to store value -> index of elements seen so far
        HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int complement = target - currentValue; // Calculating complement

            // If the complement is already in the map, return the indices
            if (valueToIndexMap.containsKey(complement)) {
                return new int[]{valueToIndexMap.get(complement), i}; // Checking for the complement in the map
            }

            // Otherwise, store the current value with its index
            valueToIndexMap.put(currentValue, i); // Adding current number and index to the map
        }

        // If no valid pair found, return an empty array
        return new int[]{};
    }
}

// Design Choice:
// - **HashMap** is chosen for O(1) average lookup time to check if the complement has already been seen.
// - This makes the solution run in **O(n)** time, where n is the number of elements in the input array.
