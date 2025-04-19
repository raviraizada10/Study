package com.leetcode.essential.oneFifty.array;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/zigzag-conversion/description/", problemNumber = "6", solutionLink = "https://algo.monster/liteproblems/6")
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        List<StringBuilder> rows = new ArrayList<>();
        int currRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < numRows; i++) {
         rows.add(new StringBuilder());
        }

        for (char ch : s.toCharArray()) {
            rows.get(currRow).append(ch);
            if(currRow == 0 || currRow== numRows-1) goingDown = !goingDown;
            currRow+=goingDown ? 1:-1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}   