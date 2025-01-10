package com.gfg.gfg160.twopointer;

import java.util.Arrays;

public class CountTriangles {
    /**
     * Counts the number of valid triangles that can be formed with elements of the given array.
     * <p>
     * A triangle is valid if the sum of the lengths of any two sides is greater than the third side.
     * This method sorts the array and uses a two-pointer approach to efficiently count the triangles.
     *
     * @param arr an array of integers representing the sides of triangles
     * @return the number of valid triangles that can be formed
     */
    static int countTriangles(int[] arr) {
        int triangleCount = 0; // Stores the total number of valid triangles
        Arrays.sort(arr); // Sort the array to simplify triangle inequality checks

        // Iterate through the array, fixing the largest side at arr[largestSideIndex]
        for (int largestSideIndex = 2; largestSideIndex < arr.length; ++largestSideIndex) {
            int smallestSideIndex = 0; // Pointer for the smallest side
            int middleSideIndex = largestSideIndex - 1; // Pointer for the middle side

            // Check all pairs (smallestSideIndex, middleSideIndex) for the current largest side
            while (smallestSideIndex < middleSideIndex) {
                // If the sum of the smallest and middle sides is greater than the largest side
                if (arr[smallestSideIndex] + arr[middleSideIndex] > arr[largestSideIndex]) {
                    // All pairs between smallestSideIndex and middleSideIndex are valid
                    triangleCount += middleSideIndex - smallestSideIndex;

                    // Move the middle side pointer left to explore smaller pairs
                    middleSideIndex--;
                }
                else {
                    // Otherwise, move the smallest side pointer right to increase the sum
                    smallestSideIndex++;
                }
            }
        }

        return triangleCount; // Return the total count of valid triangles
    }
}
