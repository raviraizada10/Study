package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;
import java.util.Map;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, HASH_TABLE, SIMULATION})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/", problemNumber = "3160", solutionLink = "https://algo.monster/liteproblems/3160")
public class DistinctColors {
    /**
     * Processes queries to determine the number of distinct colors after each operation.
     *
     * @param limit   The number of distinct balls available.
     * @param queries A 2D array where each query consists of [ball, color].
     * @return An array containing the count of distinct colors after each query.
     */
    public int[] queryResults(int limit, int[][] queries) {
        // Maps a ball to its current color
        Map<Integer, Integer> ballToColorMap = new HashMap<>();
        // Stores the count of each color across all balls
        Map<Integer, Integer> colorFrequencyMap = new HashMap<>();
        // Result array to store the distinct color count after each query
        int[] distinctColorResults = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];   // Ball ID
            int newColor = queries[i][1]; // Color assigned in the current query

            // If the ball already has a color, update the color frequency
            if (ballToColorMap.containsKey(ball)) {
                int previousColor = ballToColorMap.get(ball);
                colorFrequencyMap.compute(previousColor, (col, count) -> (count == 1) ? null : count - 1);
            }

            // Assign the new color to the ball
            ballToColorMap.put(ball, newColor);
            // Update the frequency of the new color
            colorFrequencyMap.put(newColor, colorFrequencyMap.getOrDefault(newColor, 0) + 1);

            // Store the current count of distinct colors
            distinctColorResults[i] = colorFrequencyMap.size();
        }

        return distinctColorResults;
    }
}   