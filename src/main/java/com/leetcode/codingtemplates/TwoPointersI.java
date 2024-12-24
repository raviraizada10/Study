package com.leetcode.codingtemplates;

//Two pointers: one input, opposite ends
public class TwoPointersI {
    private static final boolean CONDITION = true;

    public int fn(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int ans = 0;

        while (left < right) {
            // do some logic here with left and right
            if (CONDITION) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
