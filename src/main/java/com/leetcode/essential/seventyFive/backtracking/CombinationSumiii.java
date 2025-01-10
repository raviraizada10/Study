package com.leetcode.essential.seventyFive.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
//https://algo.monster/liteproblems/216
public class CombinationSumiii {
    // List to store the final valid combinations
    private List<List<Integer>> combinations = new ArrayList<>();
    // Temporary list to store the current combination being explored
    private List<Integer> currentCombination = new ArrayList<>();
    // The number of numbers to use in each combination
    private int combinationLength;

    /**
     * Finds all valid combinations of `k` numbers that add up to `n`.
     * Each combination must contain only numbers from 1 to 9, and no number
     * can be used more than once.
     *
     * @param k The number of numbers to use in each combination.
     * @param n The target sum for the combinations.
     * @return A list of all valid combinations.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        // Store the required combination length
        this.combinationLength = k;
        // Start the recursive search from the number 1 with the target sum `n`
        searchCombinations(1, n);
        // Return the list of valid combinations
        return combinations;
    }

    /**
     * Recursive helper method to find all combinations.
     *
     * @param start        The current number being considered for inclusion.
     * @param remainingSum The remaining sum needed to reach the target `n`.
     */
    private void searchCombinations(int start, int remainingSum) {
        // If the remaining sum is zero and the current combination size matches the target length
        if (remainingSum == 0) {
            if (currentCombination.size() == combinationLength) {
                // Add a copy of the current combination to the result list
                combinations.add(new ArrayList<>(currentCombination));
            }
            return; // Backtrack as we have either found a valid combination or exhausted possibilities
        }

        // If the current number exceeds 9, the remaining sum, or if we already have enough numbers in the combination
        if (start > 9 || start > remainingSum || currentCombination.size() >= combinationLength) {
            return; // Cannot proceed further, backtrack
        }

        // Include the current number in the combination
        currentCombination.add(start);
        // Recursively search for combinations starting from the next number, with an updated remaining sum
        searchCombinations(start + 1, remainingSum - start);

        // Exclude the current number from the combination (backtrack)
        currentCombination.remove(currentCombination.size() - 1);
        // Recursively search for combinations starting from the next number without including the current one
        searchCombinations(start + 1, remainingSum);
    }
}
