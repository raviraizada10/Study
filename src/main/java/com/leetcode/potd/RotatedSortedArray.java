package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/", problemNumber = "1752", solutionLink = "https://algo.monster/liteproblems/1752")
public class RotatedSortedArray {
    public boolean check(int[] nums) {
        var checkFlip = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[i+1]) checkFlip++;
        }
        return checkFlip == 1;
    }
}   