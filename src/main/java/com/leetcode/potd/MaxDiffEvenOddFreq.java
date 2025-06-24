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
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/", problemNumber = "3442", solutionLink = "https://algo.monster/liteproblems/3442")
public class MaxDiffEvenOddFreq {
    public int maxDifference(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for (char ch : s.toCharArray()) {
            freqMap.merge(ch, 1, Integer::sum);
        }
        for (Integer freq : freqMap.values()) {
            if (freq % 2 == 0) {
                minEven = Math.min(minEven, freq);
            }
            else {
                maxOdd = Math.max(maxOdd, freq);
            }
        }

        return maxOdd - minEven;
    }
}   