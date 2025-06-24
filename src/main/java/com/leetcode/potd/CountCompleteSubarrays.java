package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashSet;
import java.util.Set;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-complete-subarrays-in-an-array/", problemNumber = "2799", solutionLink = "https://algo.monster/liteproblems/2799")
public class CountCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int uniqueElements = unique.size();

        int completeSubarraysCount = 0;

        for (int start = 0; start < nums.length; start++) {
            HashSet<Integer> currentSubarrayDistinct = new HashSet<>();
            for (int end = start; end < nums.length; end++) {
                currentSubarrayDistinct.add(nums[end]);
                if (currentSubarrayDistinct.size() == uniqueElements) {
                    completeSubarraysCount++;
                }
            }
        }
        return completeSubarraysCount;
    }
}   