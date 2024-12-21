package com.gfg.gfg160.arrays;

public class AntLastMoment {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTimeLeft = 0;
        int maxTimeRight = 0;

        // Calculate the maximum time for ants moving to the left
        for (int position : left) {
            maxTimeLeft = Math.max(maxTimeLeft, position);
        }

        // Calculate the maximum time for ants moving to the right
        for (int position : right) {
            maxTimeRight = Math.max(maxTimeRight, n - position);
        }

        // The result is the maximum of the two times
        return Math.max(maxTimeLeft, maxTimeRight);
    }
}
