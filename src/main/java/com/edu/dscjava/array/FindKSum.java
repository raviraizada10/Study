package com.edu.dscjava.array;

import java.util.Arrays;
import java.util.Collections;

public class FindKSum {
    public static int[] findSum(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0, j = arr.length - 1; i < j; ) {
            if (arr[i] + arr[j] == n) return new int[]{arr[i], arr[j]};
            else if (arr[i] + arr[j] < n) i++;
            else j--;
        }
        return new int[]{};
    }

    //Binary Search Solution

    public static int binarySearch(int[] a, int item) {
        int first = 0;
        int last = a.length - 1;
        boolean found = false;
        int index = -1;
        while (first <= last && !found) {
            int mid = (first + last) / 2;
            if (a[mid] == item) {
                index = mid;
                found = true;
            }
            else {
                if (item < a[mid]) {
                    last = mid - 1;
                }
                else {
                    first = mid + 1;
                }
            }
        }
        if (found) {
            return index;
        }
        else {
            return -1;
        }
    }

    public static int[] findSumBinary(int[] nums, int k) {
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {
            int index = binarySearch(nums, k - nums[j]);
            if (index != -1 && index != j) {
                return new int[]{nums[j], k - nums[j]};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3, 4},
                {1, 2},
                {2, 2},
                {-4, -1, -9, 1, -7},
                {25, 50, 75, 100, 400}};

        int[] k = {5, 3, 4, -3, 425};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            System.out.println("\tk: " + k[i]);

            int[] result = findSumBinary(inputs[i], k[i]);
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }
    }
}
