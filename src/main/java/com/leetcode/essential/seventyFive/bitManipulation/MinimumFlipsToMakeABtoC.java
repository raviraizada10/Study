package com.leetcode.essential.seventyFive.bitManipulation;

public class MinimumFlipsToMakeABtoC {
    /**
     * Calculates the minimum number of bit flips required to make (a | b == c).
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param c The target integer.
     * @return The minimum number of bit flips required.
     */
    public int minFlips(int a, int b, int c) {
        // Initialize the counter for minimum flips.
        var minFlips = 0;

        // Iterate over each bit position (up to 30 bits).
        for (int i = 0; i < 30; i++) {
            // Extract the i-th bit of a, b, and c using bitwise operations.
            var bitA = (a >> i) & 1;
            var bitB = (b >> i) & 1;
            var bitC = (c >> i) & 1;

            // Check if the current bit of (a | b) matches the corresponding bit in c.
            if ((bitA | bitB) != bitC) {
                // If both bitA and bitB are 1 and bitC is 0, two flips are required.
                // Otherwise, only one flip is needed.
                minFlips += (bitA == 1 && bitB == 1) ? 2 : 1;
            }
        }

        // Return the total number of flips required.
        return minFlips;
    }
}
