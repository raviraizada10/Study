package com.gfg.gfg160.twopointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctElementWindow {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> windowSet = new HashSet<>();

        // Add the first window elements to the set
        for (int i = 0; i < k; i++) {
            windowSet.add(arr[i]);
        }
        result.add(windowSet.size()); // Add the number of distinct elements in the first window

        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            // Remove the element that is sliding out of the window
            windowSet.remove(arr[i - k]);
            // Add the new element that is sliding into the window
            windowSet.add(arr[i]);
            // Add the size of the set (number of distinct elements) to the result
            result.add(windowSet.size());
        }

        return result;
    }
}
