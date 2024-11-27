package com.codingninjas.babbar.ds.array.easy;

import java.util.ArrayList;

public class SeparateNegativePositive {

    public static ArrayList<Integer> separateNegativeAndPositive(ArrayList<Integer> nums) {
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) < 0) {
                i++;
            }
            else if (nums.get(j) >= 0) {
                j--;
            }
            else if (nums.get(i) > 0 && nums.get(j) < 0) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}

