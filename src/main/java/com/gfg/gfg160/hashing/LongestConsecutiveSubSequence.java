package com.gfg.gfg160.hashing;

import java.util.HashSet;

public class LongestConsecutiveSubSequence {
    public int longestConsecutive(int[] arr) {
        var elementsSet = new HashSet<Integer>();
        var maxLength = 0;
        for (int element : arr) {
            elementsSet.add(element);
        }
        for (Integer element : elementsSet) {
            if (!elementsSet.contains(element - 1)) {
                int current = element;
                int currentLen = 1;
                while (elementsSet.contains(current + 1)) {
                    currentLen++;
                    current++;
                }
                maxLength = Math.max(currentLen, maxLength);
            }
        }
        return maxLength;
    }
}
