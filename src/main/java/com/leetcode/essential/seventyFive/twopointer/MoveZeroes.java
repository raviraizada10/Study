package com.leetcode.essential.seventyFive.twopointer;

//https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
         while (right < nums.length) {
            if (nums[right]!=0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
