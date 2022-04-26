package com.codingninjas.babbar.ds.array.easy;

// https://www.codingninjas.com/codestudio/problems/find-similarities-between-two-arrays_1229070?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://www.codingninjas.com/codestudio/problems/find-similarities-between-two-arrays_1229070?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0">Find Similarities</a>
 */
public class FindSimilarity {

    public static ArrayList<Integer> findSimilarity(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {
        Set<Integer> union = new HashSet<>(arr1);
        union.addAll(arr2);
        Set<Integer> intersection = arr2
                .stream()
                .filter(arr1::contains)
                .collect(Collectors.toSet());
        return new ArrayList<>(Arrays.asList(intersection.size(), union.size()));
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 4));
        System.out.println(findSimilarity(arr1, arr2, 2, 2));

        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(4, 6, 2));
        System.out.println(findSimilarity(arr3, arr4, 5, 3));
    }
}
