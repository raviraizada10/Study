package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(EASY)
@ProblemCategory({MATH, STRING, BIT_MANIPULATION, SIMULATION})
@ProblemInfo(problemLink = "https://leetcode.com/problems/add-binary/", problemNumber = "67", solutionLink = "https://algo.monster/liteproblems/67")
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result
                .reverse()
                .toString();
    }
}   