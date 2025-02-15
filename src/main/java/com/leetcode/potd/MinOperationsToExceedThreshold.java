package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.PriorityQueue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/", problemNumber = "3066", solutionLink = "https://algo.monster/liteproblems/3066")
public class MinOperationsToExceedThreshold {
    public int minOperations(int[] nums, int k) {
        var operations = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer((long)num);
        }

        while (!minHeap.isEmpty() && minHeap.peek() < k) {
            var min = minHeap.poll();
            var secondMin = minHeap.poll();
            var res = min * 2 + secondMin;
            minHeap.offer(res);
            operations++;
        }
        return operations;
    }
}   