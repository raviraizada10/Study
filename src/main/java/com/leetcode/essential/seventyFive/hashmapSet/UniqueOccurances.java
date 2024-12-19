package com.leetcode.essential.seventyFive.hashmapSet;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueOccurances {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Create a map of the frequencies of each element in the array
        var mapOfFreq = Arrays
                .stream(arr)                         // Convert the array to a stream
                .boxed()                              // Box each element from int to Integer
                .collect(Collectors.groupingBy(       // Collect the stream into a map
                        Function.identity(),         // Group by the element itself (identity function)
                        Collectors.counting()));      // Count the occurrences of each element

        // Step 2: Convert the frequency values (counts) into a set to eliminate duplicates
        Set<Long> uniqueFrequencies = new HashSet<>(mapOfFreq.values());  // Store only unique frequency values

        // Step 3: Check if the number of unique frequencies equals the number of elements in the map
        // If they are equal, it means all frequencies are distinct, so return true
        return uniqueFrequencies.size() == mapOfFreq.size();  // If any frequency is repeated, sizes will differ
    }


    public static boolean uniqueOccurrencesWithoutStreams(int[] arr) {
        // Step 1: Create a map of the frequencies of each element in the array
        Map<Integer, Long> mapOfFreq = new HashMap<>();

        // Count frequencies using a for-loop
        for (int num : arr) {
            mapOfFreq.put(num, mapOfFreq.getOrDefault(num, 0L) + 1);
        }

        // Step 2: Convert the frequency values into a set to eliminate duplicates
        Set<Long> uniqueFrequencies = new HashSet<>(mapOfFreq.values());  // Store only unique frequency values

        // Step 3: Check if the number of unique frequencies equals the number of elements in the map
        return uniqueFrequencies.size() == mapOfFreq.size();  // If any frequency is repeated, sizes will differ
    }
}
