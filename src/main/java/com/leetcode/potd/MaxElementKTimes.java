package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/", problemNumber = "2962", solutionLink = "https://algo.monster/liteproblems/2962")
public class MaxElementKTimes {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = nums[0];
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        int left = 0, count = 0;
        long result = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxElement) {
                count++;
            }
            while (count >= k) {
                if (nums[left] == maxElement) {
                    count--;
                }
                left++;
            }
            result += left;
        }
        return result;
    }
}
