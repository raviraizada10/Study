package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Stack;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(EASY)
@ProblemCategory({STRING, STACK, SIMULATION})
@ProblemInfo(problemLink = "https://leetcode.com/problems/clear-digits/", problemNumber = "3174", solutionLink = "https://algo.monster/liteproblems/3174")
public class ClearDigits {
    public String clearDigits(String s) {
        Stack<Character> wordStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            wordStack.push(s.charAt(i));
            if(Character.isDigit(wordStack.peek())){
                wordStack.pop();
                if(wordStack.isEmpty()) return "";
                wordStack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        while(!wordStack.isEmpty()){
            result.append(wordStack.pop());
        }
        return result.reverse().toString();
    }
}   