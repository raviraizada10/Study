package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/merge-intervals/", problemNumber = "56", solutionLink = "https://algo.monster/liteproblems/56")
public class MergeIntervals {
    /**
     * 📝 Merge Intervals – Sorting + Greedy Merge
     * Sort intervals based on start time.
     * Iterate through each interval and compare it with the last merged one.
     * If they overlap, merge by updating the end time to the max of both.
     * If not, add the current interval as a new entry.
     * This ensures all overlapping intervals are merged efficiently.
     *
     * @param intervals 2D array where each element is an interval [start, end]
     * @return a new 2D array with all overlapping intervals merged
     * <p>
     * Edge Cases:
     * - If intervals array is empty, returns an empty array.
     * - If no intervals overlap, returns the original set in sorted order.
     */
    public int[][] merge(int[][] intervals) {
        // Sort intervals by their start time to simplify merging logic
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int[] currentInterval : intervals) {
            // If the merged list is empty OR current interval does not overlap with the last one
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < currentInterval[0]) {
                mergedIntervals.add(currentInterval); // Add as is
            }
            else {
                // Overlap exists: merge by updating the end of the last interval
                mergedIntervals.get(mergedIntervals.size() - 1)[1] =
                        Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], currentInterval[1]);
            }
        }

        // Convert merged intervals list back to 2D array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}