package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/", problemNumber = "3392", solutionLink = "https://algo.monster/liteproblems/3392")
public class SubarrayLengthThree {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int sumFirstThird = nums[i - 1] + nums[i + 1];
            int sumSecond = nums[i];
            if (sumSecond % 2 == 0 && sumFirstThird == sumSecond / 2)
                count++;
        }
        return count;
    }
}   