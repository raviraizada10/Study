package com.leetcode.essential.oneFifty.intervals;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/summary-ranges/description/", problemNumber = "228", solutionLink = "https://algo.monster/liteproblems/228")
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int initialRange = nums[i];
            while(i+1 < nums.length && nums[i] + 1 == nums[i+1]){
                i++;
            }
            result.add(initialRange == nums[i] ? String.valueOf(initialRange): initialRange + "->"+nums[i]);
        }
        return result;
    }
}   