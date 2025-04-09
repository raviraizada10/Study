package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/number-of-islands/", problemNumber = "200", solutionLink = "https://algo.monster/liteproblems/200")
public class NumIsland {
    /**
     * Counts the number of islands in a 2D grid where '1' represents land and '0' represents water.
     * Uses DFS to visit and mark all connected land as visited by converting it to '0'.
     *
     * @param grid 2D character array representing a map of '1's (land) and '0's (water)
     * @return the number of distinct islands found in the grid
     *
     * Edge Cases:
     * - If grid is null or empty, returns 0.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int islandCount = 0;

        // Iterate through each cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // If cell is land ('1'), it's a new island
                if (grid[row][col] == '1') {
                    islandCount++;
                    dfs(grid, row, col); // Mark the entire island as visited
                }
            }
        }

        return islandCount;
    }

    /**
     * Depth-first search to mark all land connected to the current cell as visited.
     *
     * @param grid 2D grid of land and water
     * @param row current row index
     * @param col current column index
     */
    private void dfs(char[][] grid, int row, int col) {
        // Base case: if out of bounds or water cell, return
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;

        // Mark current cell as visited
        grid[row][col] = '0';

        // Visit all 4 neighboring cells (up, down, left, right)
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}