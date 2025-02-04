package com.leetcode.essential.seventyFive.intervals;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;
import java.util.Comparator;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, GREEDY, SORTING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/", problemNumber = "452", solutionLink = "https://algo.monster/liteproblems/452")
public class MinArrowShots {

    /**
     * Finds the minimum number of arrows required to burst all balloons.
     * Each balloon is represented as an interval [start, end] in the input array.
     * An arrow shot at position x will burst all balloons where start <= x <= end.
     * <p>
     * The strategy is to sort the balloons by their end positions, then iteratively
     * select the balloon with the earliest end that hasn't been burst yet. This greedy
     * approach ensures that we burst the maximum number of balloons with each arrow.
     *
     * @param points A 2D array where each sub-array represents a balloon's interval [start, end].
     * @return The minimum number of arrows required to burst all the balloons.
     * <p>
     * Edge Cases:
     * - If the input array is empty, the method returns 0.
     * - Works correctly even if intervals overlap heavily or are completely separate.
     */
    public int findMinArrowShots(int[][] points) {
        // Initialize the position of the last arrow shot to a very small value.
        // We use Long.MIN_VALUE to ensure that the first balloon always triggers an arrow.
        long currentArrowPosition = Long.MIN_VALUE;

        // Counter for the number of arrows used.
        int arrowCount = 0;

        // Sort the balloons by their ending positions in ascending order.
        // This greedy strategy allows us to cover as many balloons as possible with one arrow.
        Arrays.sort(points, Comparator.comparingInt(interval -> interval[1]));

        // Iterate through each balloon (interval)
        for (int i = 0; i < points.length; i++) {
            // If the start of the current balloon is greater than the position of the last arrow,
            // it means the current balloon was not burst by the previous arrow, so we need a new arrow.
            if (points[i][0] > currentArrowPosition) {
                arrowCount++;                  // Increment the arrow counter.
                currentArrowPosition = points[i][1]; // Update the arrow position to the end of the current balloon.
            }
        }

        // Return the total number of arrows needed.
        return arrowCount;
    }

}   