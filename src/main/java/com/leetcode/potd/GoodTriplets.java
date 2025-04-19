package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-good-triplets/description/", problemNumber = "1534", solutionLink = "https://algo.monster/liteproblems/1534")
public class GoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int iNum = arr[i];
                    int jNum = arr[j];
                    int kNum = arr[k];
                    if (Math.abs(iNum - jNum) <= a && Math.abs(jNum - kNum) <= b && Math.abs(iNum - kNum) <= c) count++;
                }
            }
        }
        return count;
    }
}   