package com.leetcode.essential.seventyFive.twopointer;

//https://leetcode.com/problems/container-with-most-water/submissions/1466713762/?envType=study-plan-v2&envId=leetcode-75
public class MaxArea {
    public int maxArea(int[] height) {
        // Initialize the maximum area variable to 0
        int maxArea = 0;

        // Initialize two pointers: one at the beginning (i) and one at the end (j) of the array
        int i = 0, j = height.length - 1;

        // Loop until the two pointers meet
        while (i < j) {
            // Get the heights at the two pointers
            int leftHeight = height[i];
            int rightHeight = height[j];

            // Calculate the area of the container formed by the two heights
            // The area is the minimum height of the two multiplied by the width between them
            int area = Math.min(leftHeight, rightHeight) * (j - i);

            // Update the maximum area if the current area is greater than the previous max
            maxArea = Math.max(maxArea, area);

            // Move the pointer of the smaller height
            // Since the smaller height limits the area, moving the pointer of the smaller height
            // increases the chance of finding a larger container
            if (leftHeight < rightHeight) {
                i++; // Move the left pointer inward
            }
            else {
                j--; // Move the right pointer inward
            }
        }

        // Return the maximum area found
        return maxArea;
    }
}
