package com.gfg.gfg160.searching;

import java.util.Arrays;

public class CountFrequency {
    int countFreq(int[] arr, int target) {
        return (int) Arrays
                .stream(arr)
                .filter(value -> target == value)
                .count();
    }
}
