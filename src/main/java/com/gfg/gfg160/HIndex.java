package com.gfg.gfg160;

import java.util.Arrays;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/find-h-index--165609
public class HIndex {
    /**
     * Computes the h-index for a researcher based on their citation counts.
     * <p>
     * The h-index is the maximum value of h such that the researcher has at least
     * h papers with h or more citations each.
     *
     * @param citations an array of integers representing the citation counts for each paper
     * @return the h-index
     */
    public int hIndex(int[] citations) {
        // Sort the citations array in ascending order
        Arrays.sort(citations);

        // Iterate through the sorted array to find the h-index
        for (int i = 0; i < citations.length; i++) {
            // Calculate the number of papers with at least citations[i] citations
            int h = citations.length - i;

            // Check if the current citation count satisfies the h-index condition
            if (citations[i] >= h) {
                return h; // Found the h-index
            }
        }

        // If no valid h-index is found, return 0
        return 0;
    }
}
