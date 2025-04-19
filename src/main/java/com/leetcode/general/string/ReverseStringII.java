package com.leetcode.general.string;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/reverse-string-ii/", problemNumber = "541", solutionLink = "https://algo.monster/liteproblems/541")
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int startIndex = 0; startIndex < charArray.length; startIndex += (k * 2)) {
            int endIndex = Math.min(charArray.length - 1, startIndex + k - 1);
            reverseCharacters(charArray, startIndex, endIndex);
        }
        return new String(charArray);
    }

    private void reverseCharacters(char[] charArray, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = charArray[startIndex];
            charArray[startIndex] = charArray[endIndex];
            charArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
