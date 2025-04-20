package com.leetcode.top100Liked;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/permutations/description/", problemNumber = "46", solutionLink = "https://algo.monster/liteproblems/46")
public class Permutations {

    /**
     * Build permutations by choosing unused elements one by one.
     * Use a used[] array to track elements already included in the current path.
     * At each recursive call, add an unused element, recurse, then backtrack by removing it.
     * Continue until the path size equals the input length — then add it to the result.
     **/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used, result);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}   