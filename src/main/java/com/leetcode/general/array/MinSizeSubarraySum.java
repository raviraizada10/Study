package com.leetcode.general.array;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, BINARY_SEARCH, SLIDING_WINDOW, PREFIX_SUM})
@ProblemInfo(problemLink = "https://leetcode.com/problems/minimum-size-subarray-sum/", problemNumber = "209", solutionLink = "https://algo.monster/liteproblems/209")
public class MinSizeSubarraySum {
//    public int minSubArrayLen(int target, int[] nums) {
//        int minLen = 0;
//        int currSum = nums[0];
//        int i = 0, j =1;
//        if (nums.length == 1 && nums[0] == target) return 1;
//        while(currSum <= target){
//            currSum += nums[j];
//            minLen++;
//            j++;
//        }
//        for (int i = 0, j = 1; j < nums.length; ) {
//            if (currSum < target) {
//                currSum += nums[j];
//                minLen++;
//            }
//
//        }
//    }
}   