package com.leetcode.general.array;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.BINARY_SEARCH;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, BINARY_SEARCH})
@ProblemInfo(problemLink = "https://leetcode.com/problems/search-in-rotated-sorted-array/description/", problemNumber = "33", solutionLink = "https://algo.monster/liteproblems/33")
public class SearchRotatedSorted {
    /**
     * Searches for a target value in a rotated sorted array using binary search.
     *
     * @param nums   The rotated sorted array of integers.
     * @param target The integer value to search for.
     * @return The index of the target if found; otherwise, returns -1.
     * <p>
     * The array is assumed to be sorted in ascending order before rotation.
     * If there are duplicate values in the array, the behavior may not be consistent.
     * <p>
     * Time Complexity: O(log N) since we are performing binary search.
     * Space Complexity: O(1) as no additional space is used.
     */
    public int search(int[] nums, int target) {
        int left = 0; // Left boundary of the search space
        int right = nums.length - 1; // Right boundary of the search space

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // If the mid element is the target, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // If the target lies in this sorted left half, narrow the search to this half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Move search to the left half
                }
                else {
                    left = mid + 1; // Move search to the right half
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // If the target lies in this sorted right half, narrow the search to this half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Move search to the right half
                }
                else {
                    right = mid - 1; // Move search to the left half
                }
            }
        }
        // If the loop ends, the target was not found
        return -1;
    }
}   