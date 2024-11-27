package com.edu.dscjava.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {
    public static int[] rightRotate(int[] nums, int k) {
        int len = k % nums.length;
        if (len == 0) return nums;
        reverse(nums);
        var firstArray = Arrays.copyOfRange(nums, 0, len);
        var secondArray = Arrays.copyOfRange(nums, len, nums.length);
        reverse(firstArray);
        reverse(secondArray);
        return IntStream
                .concat(Arrays.stream(firstArray), Arrays.stream(secondArray))
                .toArray();
    }


    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
