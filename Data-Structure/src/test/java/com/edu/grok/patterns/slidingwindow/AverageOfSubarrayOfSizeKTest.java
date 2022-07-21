package com.edu.grok.patterns.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AverageOfSubarrayOfSizeKTest {

    @Test
    void findAverages() {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}