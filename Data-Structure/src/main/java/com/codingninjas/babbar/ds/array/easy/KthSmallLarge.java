package com.codingninjas.babbar.ds.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthSmallLarge {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        arr = arr
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        return new ArrayList<>(Arrays.asList(arr.get(k), arr.get(arr.size() - k)));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 4, 5, 6, 6, 6));
        kthSmallLarge(arr, 7, 3);
    }
}
