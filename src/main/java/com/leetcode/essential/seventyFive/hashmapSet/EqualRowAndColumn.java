package com.leetcode.essential.seventyFive.hashmapSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
//2532
public class EqualRowAndColumn {
    public int equalPairs(int[][] grid) {
        int n = grid.length; // Length of the matrix

        // Step 1: Create a map to store the frequency of row arrays
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        // Convert each row to a List and store its frequency
        for (int i = 0; i < n; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                rowList.add(grid[i][j]);  // Add row elements to List
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);  // Increment row frequency
        }

        int result = 0;

        // Step 2: For each column, build its List and check if it matches any row
        for (int j = 0; j < n; j++) {
            List<Integer> colList = new ArrayList<>();  // List to store column elements
            for (int i = 0; i < n; i++) {
                colList.add(grid[i][j]);  // Add column elements to List
            }

            // Step 3: If the column List exists in the row map, add the frequency to the result
            result += rowMap.getOrDefault(colList, 0);  // Increment result with the count of matching rows
        }

        return result;  // Return the count of matching row-column pairs
    }

}
