package com.leetcode.essential.seventyFive.prefixSum;

//https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
//1732
public class LargestAltitude {
    public int largestAltitude(int[] gain) {
        // maxSum stores the maximum altitude reached.
        int maxSum = 0;

        // Create an altitude array with one extra space to store altitude at each step.
        // The first element is the starting point with altitude 0.
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;  // Initialize the first element to 0 since we start from the ground level.

        // Fill in the altitude array by adding each gain to the previous altitude.
        for (int i = 0; i < gain.length; i++) {
            altitude[i + 1] = altitude[i] + gain[i];  // Update the altitude at each step.
        }

        // Find the maximum altitude in the altitude array.
        for (int i = 0; i < altitude.length; i++) {
            maxSum = Math.max(maxSum, altitude[i]);  // Track the maximum altitude.
        }

        // Return the maximum altitude reached.
        return maxSum;
    }


    //Optimised Approach Without Array
    public int largestAltitudeOptimised(int[] gain) {
        // maxAltitude stores the maximum altitude reached.
        int maxAltitude = 0;

        // currentAltitude keeps track of the current altitude starting at 0.
        int currentAltitude = 0;

        // Loop through the gain array to calculate the current altitude at each step.
        for (int g : gain) {
            currentAltitude += g;  // Update the current altitude by adding the gain.
            maxAltitude = Math.max(maxAltitude, currentAltitude);  // Track the maximum altitude.
        }

        // Return the highest altitude reached.
        return maxAltitude;
    }

}
