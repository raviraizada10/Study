package com.edu.dscjava.array;

public class FirstNonRepeatingInteger {
    public static int findFirstUnique(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                i++;
            else if (nums[i] != nums[i + 1])
                return nums[i];
        }
        return -1;
    }
}
