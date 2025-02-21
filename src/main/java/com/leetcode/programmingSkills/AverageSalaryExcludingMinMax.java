package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.SORTING;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY, SORTING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/", problemNumber = "1492", solutionLink = "https://algo.monster/liteproblems/1492")
public class AverageSalaryExcludingMinMax {
    public double average(int[] salary) {
        var minSal = salary[0];
        var maxSal = salary[0];
        int sum = 0;
        for (int currentSal : salary) {
            minSal = Math.min(minSal, currentSal);
            maxSal = Math.max(maxSal, currentSal);
            sum += currentSal;
        }
        sum -= maxSal + minSal;
        return sum / (double) (salary.length - 2);
    }
}   