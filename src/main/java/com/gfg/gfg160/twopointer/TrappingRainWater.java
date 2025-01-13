package com.gfg.gfg160.twopointer;

public class TrappingRainWater {
    public int maxWater(int arr[]) {
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        int[] leftArray = new int[arr.length];
        int[] rightArray = new int[arr.length];

        // Calculate the maximum height from the left for each position
        for (int i = 0; i < arr.length; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            leftArray[i] = leftMax;
        }

        // Calculate the maximum height from the right for each position
        for (int i = arr.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, arr[i]);
            rightArray[i] = rightMax;
        }

        // Calculate the water trapped at each position
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i < arr.length - 1) { // Ensure valid boundaries
                int currentWater = Math.min(leftArray[i], rightArray[i]) - arr[i];
                result += Math.max(0, currentWater); // Only add positive water
            }
        }

        return result;
    }
}
