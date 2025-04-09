package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.LinkedHashSet;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/", problemNumber = "873", solutionLink = "https://algo.monster/liteproblems/873")
public class LengthOfLongestFibonacci {
    public int lenLongestFibSubseq(int[] arr) {
        LinkedHashSet<Integer> fibonacciSet = createFibonacciArray(arr[arr.length - 1]);
        return -1;
        }

    private LinkedHashSet<Integer> createFibonacciArray(int n) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        int a = 1, b = 1;
        result.add(a);
        result.add(b);
        while (true) {
            int next = a + b;
            if (next > n) break;
            result.add(next);
            a = b;
            b = next;
        }
        return result;
    }
}   