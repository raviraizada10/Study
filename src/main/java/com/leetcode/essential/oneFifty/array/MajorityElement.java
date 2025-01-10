package com.leetcode.essential.oneFifty.array;

//https://leetcode.com/problems/majority-element/description/
//https://algo.monster/liteproblems/169
public class MajorityElement {
    /**
     * Finds the majority element in the array.
     * The majority element is the element that appears more than n / 2 times, where n is the length of the array.
     * <p>
     * This method uses the Boyer-Moore Voting Algorithm, which runs in linear time and uses constant space.
     *
     * @param nums the input array of integers
     * @return the majority element if one exists, otherwise the candidate element
     */
    public int majorityElement(int[] nums) {
        // `count` keeps track of the current count for the candidate element
        int count = 0;

        // `candidate` stores the current candidate for majority element
        int candidate = 0;

        // Iterate through the array to find the majority element
        for (int num : nums) {
            // If count is zero, update the candidate to the current number
            if (count == 0) {
                candidate = num;
                count = 1; // Set count to 1 for the new candidate
            }
            // If the current number is the same as the candidate, increment the count
            else if (num == candidate) {
                count++;
            }
            // If the current number is different, decrement the count
            else {
                count--;
            }
        }

        // After the loop, `candidate` holds the majority element
        return candidate;
    }
}
