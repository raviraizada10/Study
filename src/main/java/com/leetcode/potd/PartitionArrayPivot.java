//package com.leetcode.potd;
//
//import com.customannotation.DifficultyLevel;
//import com.customannotation.ProblemCategory;
//import com.customannotation.ProblemInfo;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static com.customannotation.enums.Difficulty.MEDIUM;
//import static com.customannotation.enums.ProblemTag.ARRAY;
//
//@DifficultyLevel(MEDIUM)
//@ProblemCategory({ARRAY})
//@ProblemInfo(problemLink = "https://leetcode.com/problems/partition-array-according-to-given-pivot/", problemNumber = "2161", solutionLink = "https://algo.monster/liteproblems/2161")
//public class PartitionArrayPivot {
//    public int[] pivotArray(int[] nums, int pivot) {
//        List<Integer> lessThanPivot = new LinkedList<>();
//        List<Integer> greaterThanPivotThanPivot = new LinkedList<>();
//        for (int num : nums) {
//            if (num < pivot) lessThanPivot.add(num);
//            else if (num > pivot) greaterThanPivotThanPivot.add(num);
//            else greaterThanPivotThanPivot.addFirst(num);
//        }
//
//        int i = 0;
//        for (Integer number : lessThanPivot) {
//            nums[i] = number;
//            i++;
//        }
//        for (Integer number : greaterThanPivotThanPivot) {
//            nums[i] = number;
//            i++;
//        }
//        return nums;
//    }
//
//    public int[] pivotArrayOptimised(int[] nums, int pivot) {
//        int length = nums.length;
//        int[] result = new int[length];
//        int left = 0, pivotCount = 0;
//        for (int num : nums) {
//            if (num < pivot) result[left++] = num;
//            else if (num == pivot) pivotCount++;
//        }
//
//        while (pivotCount-- > 0) result[left++] = pivot;
//
//        for (int num : nums) {
//            if (num > pivot) result[left++] = num;
//        }
//        return result;
//    }
//}