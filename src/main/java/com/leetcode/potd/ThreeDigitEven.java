package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/finding-3-digit-even-numbers/", problemNumber = "2094", solutionLink = "https://algo.monster/liteproblems/2094")
public class ThreeDigitEven {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        result.add(num);
                    }
                }
            }
        }
        int[] resArr = result
                .stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
        return resArr;
    }

    public int[] findEvenNumbersOptimised(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits)
            freq[d]++;

        List<Integer> result = new ArrayList<>();

        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100, b = (num / 10) % 10, c = num % 10;
            freq[a]--;
            freq[b]--;
            freq[c]--;

            if (freq[a] >= 0 && freq[b] >= 0 && freq[c] >= 0) {
                result.add(num);
            }

            freq[a]++;
            freq[b]++;
            freq[c]++; // Restore
        }

        return result
                .stream()
                .mapToInt(i -> i)
                .toArray();
    }
}   