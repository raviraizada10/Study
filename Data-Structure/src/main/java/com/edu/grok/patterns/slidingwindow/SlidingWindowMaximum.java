package com.edu.grok.patterns.slidingwindow;

import java.util.ArrayDeque;
import java.util.List;

public class SlidingWindowMaximum {

    public static ArrayDeque<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int i = 0; i <= nums.size() - windowSize; i++) {
            int max = nums.get(i);
            for (int j = i; j < i + windowSize; j++) {
                if (max < nums.get(j)){
                    max = nums.get(j);
                }
            }
            result.add(max);
        }
        return result;
    }
}
