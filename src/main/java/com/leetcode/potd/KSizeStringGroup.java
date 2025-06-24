package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/", problemNumber = "2138", solutionLink = "https://algo.monster/liteproblems/2138")
public class KSizeStringGroup {
    public String[] divideString(String s, int k, char fill) {
        int inputLength = s.length();
        int totalPartitions = (inputLength + k - 1) / k;

        String[] partitions = new String[totalPartitions];

        if (inputLength % k != 0) {
            s += String
                    .valueOf(fill)
                    .repeat(k - inputLength % k);
        }

        for (int i = 0; i < partitions.length; ++i) {
            int start = i * k;
            int end = (i + 1) * k;

            partitions[i] = s.substring(start, end);
        }
        return partitions;
    }
}   