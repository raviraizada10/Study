package com.leetcode.essential.seventyFive;

//https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
public class ProductOfArrayExceptSelf {
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
            rightProduct *= nums[i];  // Update the running right product.
        }

        // Return the resulting array.
        return result;
    }

}
