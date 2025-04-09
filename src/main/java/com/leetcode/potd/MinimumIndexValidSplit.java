package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/minimum-index-of-a-valid-split/", problemNumber = "2780", solutionLink = "https://algo.monster/liteproblems/2780")
public class MinimumIndexValidSplit {
    public int minimumIndex(List<Integer> nums) {
        int maxFreqElement = -1;
        int maxFreq = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            int count = frequencyMap.merge(num, 1, Integer::sum);
            if (count > maxFreq) {
                maxFreq = count;
                maxFreqElement = num;
            }
        }

        for (int i = 0; i < nums.size() -1; i++) {

        }

        return -1;
    }
}   