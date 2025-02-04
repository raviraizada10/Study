package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/product-of-array-except-self/description/", problemNumber = "238", solutionLink = "https://algo.monster/liteproblems/238")
public class ProductOfArrayExceptSelf {
    /**
     * Calculates the product of all elements in the array except self for each index.
     * Uses two passes through the array to compute the left and right products for each index.
     *
     * @param nums An array of integers.
     * @return An array where each element at index i contains the product of all elements of nums except nums[i].
     * <p>
     * Edge Cases:
     * - Works correctly for arrays with zeros and negative numbers.
     * - Handles arrays of any length greater than 1.
     */
    public int[] productExceptSelf(int[] nums) {
        // Initialize the result array to store the final product values.
        int[] result = new int[nums.length];

        // Initialize `leftProduct` to keep track of the running product of elements to the left of the current index.
        int leftProduct = 1;

        // First pass: Calculate the left product for each index.
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct; // Store the running product in the result array.
            leftProduct *= nums[i]; // Update the running left product.
        }

        // Initialize `rightProduct` to keep track of the running product of elements to the right of the current index.
        int rightProduct = 1;

        // Second pass: Calculate the right product for each index and multiply with the left product stored in `result`.
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct; // Multiply the right product with the current result.
            rightProduct *= nums[i]; // Update the running right product.
        }

        // Return the resulting array.
        return result;
    }


}
