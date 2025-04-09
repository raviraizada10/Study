package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/multiply-strings/", problemNumber = "43", solutionLink = "https://algo.monster/liteproblems/43")
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        var m = num1.length();
        var n = num2.length();
        var res = new int[m + n];
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int digit : res) {
            if (!(result.isEmpty() && digit == 0)) {
                result.append(digit);
            }
        }
        return result.isEmpty() ? "0" : result.toString();
    }

}