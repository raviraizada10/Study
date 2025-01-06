package com.templates;

public class TwoPointersExhauseBoth {
    private static final boolean CONDITION = true;

    public int fn(int[] arr1, int[] arr2) {
        int i = 0, j = 0, ans = 0;

        while (i < arr1.length && j < arr2.length) {
            // do some logic here
            if (CONDITION) {
                i++;
            }
            else {
                j++;
            }
        }

        while (i < arr1.length) {
            // do logic
            i++;
        }

        while (j < arr2.length) {
            // do logic
            j++;
        }

        return ans;
    }
}
