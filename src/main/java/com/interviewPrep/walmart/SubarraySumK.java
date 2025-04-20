package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/subarray-sum-equals-k/", problemNumber = "560", solutionLink = "https://algo.monster/liteproblems/560")
public class SubarraySumK {
    /**
     * 📝 Subarray Sum Equals K – Prefix Sum + HashMap
     * Track the running prefix sum while iterating through the array.
     * Use a HashMap to store the frequency of seen prefix sums.
     * At each step, check if (current prefix sum - k) has occurred before — this means a subarray ending at the current index sums to k.
     * Efficiently counts valid subarrays in O(n) time.
     *
     * @param nums the input array of integers
     * @param k    the target sum
     * @return the number of continuous subarrays summing to k
     * <p>
     * Edge Cases:
     * - If nums is empty, returns 0.
     * - Works with negative numbers as well.
     */
    public int subarraySum(int[] nums, int k) {
        // Map to store frequency of prefix sums encountered so far
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1); // base case: prefix sum of 0 has occurred once

        int currentPrefixSum = 0;
        int subarrayCount = 0;

        for (int num : nums) {
            currentPrefixSum += num;

            // Check if there is a prefix sum that when removed leads to sum k
            if (prefixSumFrequency.containsKey(currentPrefixSum - k)) {
                subarrayCount += prefixSumFrequency.get(currentPrefixSum - k);
            }

            // Record the current prefix sum frequency
            prefixSumFrequency.merge(currentPrefixSum, 1, Integer::sum);
        }

        return subarrayCount;
    }
}