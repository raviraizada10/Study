package com.edu.dscjava.array;

public class SecondMaximum {
    public static int findSecondMaximum(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int val : nums) {
            if (val > firstMax) {
                secondMax = firstMax;
                firstMax = val;
            }
            else if (val != firstMax && val > secondMax) { // If the current number is greater than the second maximum and not equal to firstMax
                secondMax = val;
            }
        }
        return secondMax;
    }
}
