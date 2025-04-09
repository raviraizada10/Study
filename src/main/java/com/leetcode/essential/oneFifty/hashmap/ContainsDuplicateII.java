package com.leetcode.essential.oneFifty.hashmap;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/contains-duplicate-ii/", problemNumber = "219", solutionLink = "https://algo.monster/liteproblems/219")
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(indexMap.containsKey(nums[i])){
                if(i - indexMap.get(nums[i]) <= k) return true;
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }
}   