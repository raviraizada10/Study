package com.leetcode.array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] array = new int[nums1.length];
        for (int i = m -1, j = n-1, p = nums1.length -1; i >= 0 && j >= 0;) {

        }
    }

    public void swap(int[] nums1, int[] nums2, int i, int j) {
        int temp = nums1[i];
        nums1[i] = nums2[j];
        nums2[j] = temp;
    }
}
