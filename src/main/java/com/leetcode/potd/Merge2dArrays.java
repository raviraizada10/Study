package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.TreeMap;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/", problemNumber = "2570", solutionLink = "https://algo.monster/liteproblems/2570")
public class Merge2dArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int[] pair : nums1) {
            freqMap.merge(pair[0], pair[1], Integer::sum);
        }
        for (int[] pair : nums2) {
            freqMap.merge(pair[0], pair[1], Integer::sum);
        }
        return freqMap
                .entrySet()
                .stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toArray(int[][]::new);
    }
}   