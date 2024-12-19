package com.leetcode.essential.seventyFive.hashmapSet;


import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
//2215
public class DiffOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var num1Set = Arrays
                .stream(nums1).boxed().collect(Collectors.toSet());
        var num2Set =  Arrays
                .stream(nums2).boxed().collect(Collectors.toSet());
        List<List<Integer>> diff = new ArrayList<>();
        diff.add(num1Set.stream().filter(o -> !num2Set.contains(o)).collect(Collectors.toList()));
        diff.add(num2Set.stream().filter(o -> !num1Set.contains(o)).collect(Collectors.toList()));
        return diff;
    }

    public List<List<Integer>> findDifferenceByRemovingElements(int[] nums1, int[] nums2) {
        // Convert arrays to sets for faster lookup
        Set<Integer> num1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        // Create copies of the sets for mutation
        Set<Integer> uniqueToNums1 = new HashSet<>(num1Set);
        Set<Integer> uniqueToNums2 = new HashSet<>(num2Set);

        // Remove common elements
        uniqueToNums1.removeAll(num2Set);
        uniqueToNums2.removeAll(num1Set);

        // Convert to lists and return as a result
        return List.of(new ArrayList<>(uniqueToNums1), new ArrayList<>(uniqueToNums2));
    }

    public List<List<Integer>> findDifferenceUsingIntersection(int[] nums1, int[] nums2) {
        // Use sets for quick lookup
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();

        // Add all elements from nums1 and nums2 to their respective sets
        for (int num : nums1) num1Set.add(num);
        for (int num : nums2) num2Set.add(num);

        // Remove common elements while iterating (in-place difference calculation)
        List<Integer> uniqueToNums1 = new ArrayList<>();
        List<Integer> uniqueToNums2 = new ArrayList<>();
        for (int num : nums1) {
            if (!num2Set.contains(num) && num1Set.remove(num)) {
                uniqueToNums1.add(num); // Avoid duplicate additions
            }
        }
        for (int num : nums2) {
            if (!num1Set.contains(num) && num2Set.remove(num)) {
                uniqueToNums2.add(num); // Avoid duplicate additions
            }
        }

        return List.of(uniqueToNums1, uniqueToNums2);
    }

}
