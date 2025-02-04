package com.leetcode.essential.seventyFive.intervals;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Arrays;
import java.util.Comparator;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/non-overlapping-intervals/", problemNumber = "435", solutionLink = "https://algo.monster/liteproblems/435")
public class NonOverlappingIntervals {
    /**
     * Calculates the minimum number of intervals that need to be removed to ensure non-overlapping intervals.
     *
     * @param intervals An array of intervals represented as 2D arrays, where each interval is defined by its start and end times.
     *                  Each interval is represented as intervals[i] = [start, end].
     * @return The minimum number of intervals to be removed.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Edge case: If intervals array is empty or contains only one interval, no removal is needed.
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort intervals by their end times. We use a lambda expression for clarity.
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int nonOverlappingCount = 0; // Counter for non-overlapping intervals.
        int currentEnd = intervals[0][1]; // Initialize end time with the first interval's end time.

        // Iterate through sorted intervals to count non-overlapping intervals.
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0]; // Start time of the next interval.

            // Check if there is an overlap between the current interval and the next one.
            if (nextStart >= currentEnd) {
                // No overlap: Update currentEnd to the end time of the next interval.
                currentEnd = intervals[i][1];
                nonOverlappingCount++;
            }
            // If there is an overlap, skip counting this interval as non-overlapping.
        }

        // Calculate the minimum number of intervals to remove (overlaps).
        int overlapsToRemove = intervals.length - nonOverlappingCount - 1;

        return overlapsToRemove;
    }
}   