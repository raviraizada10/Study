package com.edu.dscjava.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArrays {
    public static ArrayList<Integer> mergeArraysM(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        var result = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < nums1.size() || j < nums2.size(); ) {
            if (i == nums1.size()) {
                result.addAll(nums2.subList(j, nums2.size()));
                break;
            }
            else if (j == nums2.size()) {
                result.addAll(nums1.subList(i, nums1.size()));
                break;
            }
            else if (nums1.get(i) <= nums2.get(j)) {
                result.add(nums1.get(i));
                i++;
            }
            else if (nums2.get(j) <= nums1.get(i)) {
                result.add(nums2.get(j));
                j++;
            }
        }
        return result;
    }


    public static ArrayList<Integer> mergeArrays(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        // Traverse both ArrayLists until the end of either ArrayList is reached
        while (p1 < nums1.size() && p2 < nums2.size()) {
            if (nums1.get(p1) < nums2.get(p2)) {
                result.add(nums1.get(p1));
                p1++;
            }
            else {
                result.add(nums2.get(p2));
                p2++;
            }
        }
        while (p1 < nums1.size()) {
            result.add(nums1.get(p1));
            p1++;
        }
        while (p2 < nums2.size()) {
            result.add(nums2.get(p2));
            p2++;
        }
        return result;
    }

    public static ArrayList<Integer> mergeArraysInPlace(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.size() && p2 < nums2.size()) {
            if (nums1.get(p1) > nums2.get(p2)) {
                nums1.add(p1, nums2.get(p2));
                p1++;
                p2++;
            }
            else {
                p1++;
            }
        }
        if (p2 < nums2.size()) {
            nums1.addAll(nums2.subList(p2, nums2.size()));
        }
        return nums1;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> nums1 = new ArrayList<>();
        nums1.add(new ArrayList<>(Arrays.asList(23, 33, 35, 41, 44, 47, 56, 91, 105)));
        nums1.add(new ArrayList<>(Arrays.asList(1, 2)));
        nums1.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        nums1.add(new ArrayList<>(Arrays.asList(6)));
        nums1.add(new ArrayList<>(Arrays.asList(12, 34, 45, 56, 67, 78, 89, 99)));

        ArrayList<ArrayList<Integer>> nums2 = new ArrayList<>();
        nums2.add(new ArrayList<>(Arrays.asList(32, 49, 50, 51, 61, 99)));
        nums2.add(new ArrayList<>(Arrays.asList(7)));
        nums2.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        nums2.add(new ArrayList<>(Arrays.asList(-99, -45)));
        nums2.add(new ArrayList<>(Arrays.asList(100)));

        for (int i = 0; i < nums1.size(); i++) {
            System.out.println((i + 1) + ".\tFirst array: " + nums1.get(i));
            System.out.println("\tSecond array: " + nums2.get(i));

            ArrayList<Integer> mergedArray = mergeArrays(new ArrayList<>(nums1.get(i)), new ArrayList<>(nums2.get(i)));
            System.out.println("\tMerged array: " + mergedArray);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
