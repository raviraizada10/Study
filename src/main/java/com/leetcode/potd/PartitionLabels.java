package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/partition-labels/description/", problemNumber = "763", solutionLink = "https://algo.monster/liteproblems/763")
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] indexArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            indexArray[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, indexArray[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}   