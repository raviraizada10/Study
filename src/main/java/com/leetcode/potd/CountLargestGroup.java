package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;
import java.util.Map;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/count-largest-group/", problemNumber = "1399", solutionLink = "https://algo.monster/liteproblems/1399")
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = findSum(i);
            int newCount = freqMap.merge(sum, 1, Integer::sum);
            maxSize = Math.max(maxSize, newCount);
        }

        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxSize)
                count++;
        }
        return count;
    }

    public int findSum(int n) {
        int sum = 0;
        while (n >= 1) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}   